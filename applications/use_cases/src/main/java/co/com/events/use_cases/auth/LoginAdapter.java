package co.com.events.use_cases.auth;

import co.com.events.models.domain.Attempt;
import co.com.events.models.domain.AuthLogin;
import co.com.events.models.domain.AuthToken;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.UnauthorizedException;
import co.com.events.models.repositories.IAttemptRepositoryPort;
import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import co.com.events.use_cases.jwt.JwtAdapter;
import co.com.events.use_cases.people.FindFullPeopleInformationAdapter;
import co.com.events.use_cases.users.UserDetailsAdapter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class LoginAdapter implements IUseCases<AuthLogin, AuthToken> {
    private final UserDetailsAdapter userDetailsAdapter;
    private final BCryptPasswordEncoder passwordEncoder;
    private final IAttemptRepositoryPort attemptRepositoryPort;
    private final JwtAdapter jwtAdapter;
    private final FindFullPeopleInformationAdapter findPeopleFullInformationAdapter;
    private final IUserRepositoryPort userRepositoryPort;
    @Override
    public AuthToken execute(AuthLogin authLogin) throws MessagingException, IOException {
        User user = (User) userDetailsAdapter.loadUserByUsername(authLogin.getUsername());
        Long personId = userRepositoryPort.findPersonIdByUsername(authLogin.getUsername());
        if (!verifyPassword(authLogin.getPassword(), user.getPassword())) {
            verifyAttempts(authLogin.getUsername());
            throw new UnauthorizedException(Messages.MESSAGE_LOGIN_FAILED.getMessage());
        }
        String token = jwtAdapter.generateToken(user);
        jwtAdapter.saveToken(token, token);
        return AuthToken.builder()
                .token(token)
                .message(Messages.MESSAGE_LOGIN_SUCCESS.getMessage())
                .peopleFullInformation(findPeopleFullInformationAdapter.execute(personId))
                .build();
    }
    private boolean verifyPassword(String enteredPassword, String storedPassword) {
        return passwordEncoder.matches(enteredPassword, storedPassword);
    }

    public void verifyAttempts(String username) throws MessagingException, IOException {
        Attempt attempt = attemptRepositoryPort.find(username);
        if (Objects.isNull(attempt)) {
            saveNewAttempt(username);
            return;
        }
        incrementAttemptQuantity(attempt);
        if (attempt.getQuantity() >= 3) {
            attemptRepositoryPort.delete(username);
        }
    }
    private void saveNewAttempt(String username) {
        Attempt attempt = Attempt.builder()
                .username(username)
                .quantity(1)
                .build();
        attemptRepositoryPort.save(attempt);
    }
    private void incrementAttemptQuantity(Attempt attempt) {
        attempt.setQuantity(attempt.getQuantity() + 1);
        attemptRepositoryPort.save(attempt);
    }
}

package co.com.events.use_cases.users;

import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class VerifyUsernameAdapter implements IUseCasesVoid<String> {
    private final IUserRepositoryPort userRepositoryPort;
    @Override
    public void execute(String username) {
        boolean existsByUsername = userRepositoryPort.existsByUsername(username);
        if (existsByUsername) {
            log.error("Username already exists");
            throw new BadRequestException(Messages.MESSAGE_USERNAME_ALREADY_EXISTS.getMessage());
        }
    }
}

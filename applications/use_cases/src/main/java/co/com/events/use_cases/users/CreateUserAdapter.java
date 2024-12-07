package co.com.events.use_cases.users;

import co.com.events.models.domain.User;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateUserAdapter implements IUseCases<User, User> {
    private final IUserRepositoryPort userRepositoryPort;

    @Override
    public User execute(User user) {
       if(userRepositoryPort.existsByUsername(user.getUsername())){
           log.error("Username already exists");
           throw new BadRequestException(Messages.MESSAGE_USERNAME_ALREADY_EXISTS.getMessage());
       }
       if(userRepositoryPort.existsByEmail(user.getEmail())){
           log.error("Email already exists");
           throw new BadRequestException(Messages.MESSAGE_EMAIL_ALREADY_EXISTS.getMessage());
       }
       return userRepositoryPort.save(user);
    }
}

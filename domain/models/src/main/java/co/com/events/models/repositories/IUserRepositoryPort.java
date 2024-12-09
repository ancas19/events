package co.com.events.models.repositories;

import co.com.events.models.domain.User;
import co.com.events.models.domain.UserLoginInformation;

import java.util.Optional;

public interface IUserRepositoryPort {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
    Optional<UserLoginInformation> findUserByUsernameOrEmail(String username);
    Long findPersonIdByUsername(String username);
}

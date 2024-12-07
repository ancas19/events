package co.com.events.models.repositories;

import co.com.events.models.domain.User;

public interface IUserRepositoryPort {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    User save(User user);
}

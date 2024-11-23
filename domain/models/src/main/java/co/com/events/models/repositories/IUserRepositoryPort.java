package co.com.events.models.repositories;

public interface IUserRepositoryPort {
    boolean existsByUsername(String username);
}

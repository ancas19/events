package co.com.events.postgres.adapter;

import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.postgres.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRepositoryAdapter implements IUserRepositoryPort {
    private final UserRepository userRepository;
    @Override
    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }
}

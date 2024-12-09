package co.com.events.postgres.adapter;

import co.com.events.models.domain.User;
import co.com.events.models.domain.UserLoginInformation;
import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.UsersEntity;
import co.com.events.postgres.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRepositoryAdapter implements IUserRepositoryPort {
    private final UserRepository userRepository;
    @Override
    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return this.userRepository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return Mapper.map(this.userRepository.save(Mapper.map(user, UsersEntity.class)), User.class);
    }

    @Override
    public Optional<UserLoginInformation> findUserByUsernameOrEmail(String username) {
        return this.userRepository.findByEmailOrUsername(username);
    }

    @Override
    public Long findPersonIdByUsername(String username) {
        return this.userRepository.findPersonIdByUsername( username);
    }

}

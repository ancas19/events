package co.com.events.postgres.adapter;

import co.com.events.models.domain.User;
import co.com.events.models.domain.UserLoginInformation;
import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.UsersEntity;
import co.com.events.postgres.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        return this.userRepository.findByEmailOrUsername(username)
                .map(map -> UserLoginInformation.builder()
                        .userId(Objects.isNull(map.get("ID"))?null:Long.valueOf(map.get("ID").toString()))
                        .username(Objects.isNull(map.get("USERNAME"))?null:map.get("USERNAME").toString())
                        .email(Objects.isNull(map.get("EMAIL"))?null:map.get("EMAIL").toString())
                        .changePassword(Objects.isNull(map.get("CHANGE_PASSWORD"))?null:map.get("CHANGE_PASSWORD").toString())
                        .verifyemail(Objects.isNull(map.get("VERIFY_EMAIL"))?null:map.get("VERIFY_EMAIL").toString())
                        .personId(Objects.isNull(map.get("PERSON_ID"))?null:Long.valueOf(map.get("PERSON_ID").toString()))
                        .password(Objects.isNull(map.get("PASSWORD"))?null:map.get("PASSWORD").toString())
                        .permissions(Objects.isNull(map.get("PERMISSIONS"))?null:mappPermission(map.get("PERMISSIONS")))
                        .build()

                );
    }


    @Override
    public Long findPersonIdByUsername(String username) {
        return this.userRepository.findPersonIdByUsername( username);
    }

    private List<String> mappPermission(Object permissions){
        return List.of(permissions.toString().split(","));
    }
}

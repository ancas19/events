package co.com.events.postgres.repositories;

import co.com.events.postgres.entities.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

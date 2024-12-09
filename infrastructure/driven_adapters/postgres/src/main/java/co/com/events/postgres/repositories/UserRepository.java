package co.com.events.postgres.repositories;

import co.com.events.models.domain.UserLoginInformation;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.UsersEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    @Query(value = """
            SELECT new co.com.events.models.domain.UserLoginInformation(
                u.id,
                u.username,
                u.email,
                u.change_password,
                u.verify_email,
                u.person_id,
                (
                    select hp.value from historical_passwords hp\s
                    where hp.user_id=u.user_id
                    and hp.active='SI'
                ),
                (
                    select STRING_AGG(p.value, ', ') AS permissions from permissions_roles pr\s
                    inner join permissions p on pr.permission_id=p.permission_id\s
                    where pr.role_id=u.role_id
                )
            ) 
            FROM UsersEntity u
            WHERE u.username = :username OR u.email = :username           
            """,
            nativeQuery = true)
    Optional<UserLoginInformation> findByEmailOrUsername(@Param("username") String username);

    @Query(value = """
            SELECT u.personId
            FROM UsersEntity u
            WHERE u.username = :username
            """)
    Long findPersonIdByUsername(String username);
}

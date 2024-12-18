package co.com.events.postgres.repositories;

import co.com.events.models.domain.UserLoginInformation;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.UsersEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity,Long> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
    @Query(value = """
            SELECT 
               u.user_id AS ID,
               u.username AS USERNAME,
               u.email AS EMAIL,
               u.change_password AS CHANGE_PASSWORD,
               u.verify_email AS VERIFY_EMAIL,
               u.person_id AS PERSON_ID,
               (
                   select hp.value from historical_passwords hp
                   where hp.user_id=u.user_id
                   and hp.active='SI'
                   ) AS PASSWORD,
                   (
                       select STRING_AGG(p.value, ', ')  from permissions_roles pr
                       inner join permissions p on pr.permission_id=p.permission_id
                       where pr.role_id=u.role_id
                   ) AS PERMISSIONS
               FROM users u
            WHERE u.username = :username OR u.email = :username           
            """,
            nativeQuery = true)
    Optional<Map<String, Object>> findByEmailOrUsername(@Param("username") String username);

    @Query(value = """
            SELECT u.personId
            FROM UsersEntity u
            WHERE u.username = :username
            """)
    Long findPersonIdByUsername(String username);
}

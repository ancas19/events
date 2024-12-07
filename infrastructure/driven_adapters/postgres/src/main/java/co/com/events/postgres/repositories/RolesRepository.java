package co.com.events.postgres.repositories;

import co.com.events.postgres.entities.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.management.relation.Role;
import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Long> {
    Optional<RolesEntity> findByName(String roleName);
}

package co.com.events.postgres.repositories;


import co.com.events.models.domain.PeopleFullInformation;
import co.com.events.postgres.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
    @Query(value = """
            SELECT new co.com.events.models.domain.PeopleFullInformation(
                p.personId,
                p.names,
                p.surnames,
                p.phoneNumber,
                u.username,
                (
                    SELECT r.name FROM RolesEntity r
                    WHERE r.roleId =u.roleId
                    
                ),
                u.email,
                u.verifyEmail,
                ui.changePassword
            )
            FROM PeopleEntity p                      
            INNER JOIN UsersEntity u ON p.personId = u.personId
            WHERE p.personId = :idPeople
           
          """
    )
    Optional<PeopleFullInformation> findPeopleFullInformation(Long idPeople);
}

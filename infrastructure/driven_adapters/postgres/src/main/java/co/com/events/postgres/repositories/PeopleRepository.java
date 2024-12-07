package co.com.events.postgres.repositories;


import co.com.events.postgres.entities.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeopleEntity,Long> {
    boolean existsByPhoneNumber(String phoneNumber);
}

package co.com.events.models.repositories;

import co.com.events.models.domain.People;
import co.com.events.models.domain.PeopleFullInformation;

import java.util.Optional;

public interface IPeopleRepositoryPort {
    boolean existsByPhonerNumber(String phoneNumber);
    People save(People people);
    Optional<PeopleFullInformation> findPeopleFullInformation(Long idPeople);
}

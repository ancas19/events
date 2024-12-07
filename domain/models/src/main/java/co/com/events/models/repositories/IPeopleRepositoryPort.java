package co.com.events.models.repositories;

import co.com.events.models.domain.People;

public interface IPeopleRepositoryPort {
    boolean existsByPhonerNumber(String phoneNumber);
    People save(People people);
}

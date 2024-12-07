package co.com.events.postgres.adapter;

import co.com.events.models.domain.People;
import co.com.events.models.repositories.IPeopleRepositoryPort;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.PeopleEntity;
import co.com.events.postgres.repositories.PeopleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PeopleRepositoryAdapter implements IPeopleRepositoryPort {
    private final PeopleRepository peopleRepository;

    @Override
    public boolean existsByPhonerNumber(String phoneNumber) {
        return this.peopleRepository.existsByPhoneNumber(phoneNumber);
    }

    @Override
    public People save(People people) {
        return Mapper.map(peopleRepository.save(Mapper.map(people, PeopleEntity.class)), People.class);
    }
}

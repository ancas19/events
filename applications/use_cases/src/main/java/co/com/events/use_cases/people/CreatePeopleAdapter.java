package co.com.events.use_cases.people;

import co.com.events.models.domain.People;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.repositories.IPeopleRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreatePeopleAdapter implements IUseCases<People, People> {
    private final IPeopleRepositoryPort peopleRepositoryPort;
    @Override
    public People execute(People people) {
        if(peopleRepositoryPort.existsByPhonerNumber(people.getPhoneNumber())){
            log.error("Phone number already exists");
            throw new BadRequestException(Messages.MESSAGE_PHONE_NUMBER_ALREADY_EXISTS.getMessage());
        }
        return peopleRepositoryPort.save(people);
    }
}

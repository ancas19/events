package co.com.events.use_cases.people;

import co.com.events.models.domain.PeopleFullInformation;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.NotFoundException;
import co.com.events.models.repositories.IPeopleRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindFullPeopleInformationAdapter implements IUseCases<Long, PeopleFullInformation> {
    private final IPeopleRepositoryPort peopleRepositoryPort;


    @Override
    public PeopleFullInformation execute(Long idPeople) {
        Optional<PeopleFullInformation> peopleFound=peopleRepositoryPort.findPeopleFullInformation(idPeople);
        if(peopleFound.isEmpty()){
            throw new NotFoundException(Messages.MESSAGE_PEOPLE_NOT_FOUND.getMessage());
        }
        return peopleFound.get();
    }
}

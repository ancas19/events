package co.com.events.use_cases.roles;

import co.com.events.models.domain.Roles;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.NotFoundException;
import co.com.events.models.repositories.IRolesRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindRoleByNameAdapter implements IUseCases<String, Roles> {
    private final IRolesRepositoryPort rolesRepositoryPort;
    @Override
    public Roles execute(String roleName) {
        Optional<Roles> roleFound=rolesRepositoryPort.findRoleByName(roleName);
        if(roleFound.isEmpty()){
            log.error("Role not found");
            throw new NotFoundException(Messages.MESSAGE_ROLE_NOT_FOUND.getMessage());
        }
        return roleFound.get();
    }
}

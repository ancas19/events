package co.com.events.postgres.adapter;

import co.com.events.models.domain.Roles;
import co.com.events.models.repositories.IRolesRepositoryPort;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.repositories.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesRepositoyAdapter implements IRolesRepositoryPort {
    private final RolesRepository rolesRepository;

    @Override
    public Optional<Roles> findRoleByName(String roleName) {
        return this.rolesRepository.findByName(roleName)
                .map(role-> Mapper.map(role,Roles.class));
    }
}

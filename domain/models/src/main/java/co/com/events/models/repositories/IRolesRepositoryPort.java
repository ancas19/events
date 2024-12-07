package co.com.events.models.repositories;

import co.com.events.models.domain.Roles;

import java.util.Optional;

public interface IRolesRepositoryPort {
    Optional<Roles> findRoleByName(String roleName);
}

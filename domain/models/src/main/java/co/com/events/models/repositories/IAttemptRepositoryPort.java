package co.com.events.models.repositories;

import co.com.events.models.domain.Attempt;

public interface IAttemptRepositoryPort {
    void save(Attempt attempt);
    Attempt find(String key);
    void delete(String key);
}

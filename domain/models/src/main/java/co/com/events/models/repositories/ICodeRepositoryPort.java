package co.com.events.models.repositories;

import co.com.events.models.domain.Code;

public interface ICodeRepositoryPort {
    void save(Code code);
    String findByKey(String key);
    void delete(String key);
}

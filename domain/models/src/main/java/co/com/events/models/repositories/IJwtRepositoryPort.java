package co.com.events.models.repositories;

public interface IJwtRepositoryPort {
    void save(String key, String value);
    String find(String key);
    void delete(String key);
}

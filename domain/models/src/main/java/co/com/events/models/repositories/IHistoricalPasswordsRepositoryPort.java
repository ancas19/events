package co.com.events.models.repositories;

import co.com.events.models.domain.HistoricalPassword;

import java.util.List;

public interface IHistoricalPasswordsRepositoryPort {
    boolean verifyExistsPassword(Long userId, String password);
    List<HistoricalPassword> findPasswordByUserId(Long userId);
    HistoricalPassword save(HistoricalPassword actualPassword);
    void delete(List<Long> idToDelete);
}

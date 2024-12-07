package co.com.events.postgres.adapter;

import co.com.events.models.domain.HistoricalPassword;
import co.com.events.models.repositories.IHistoricalPasswordsRepositoryPort;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.entities.HistoricalPasswordsEntity;
import co.com.events.postgres.repositories.HistoricalPasswordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasswordRepositoryAdapter implements IHistoricalPasswordsRepositoryPort {
    private final HistoricalPasswordsRepository historicalPasswordsRepository;
    @Override
    public boolean verifyExistsPassword(Long userId, String password) {
        return this.historicalPasswordsRepository.existsByUserIdAndPassword(userId, password);
    }

    @Override
    public List<HistoricalPassword> findPasswordByUserId(Long userId) {
        return Mapper.mapAll(this.historicalPasswordsRepository.findByUserId(userId), HistoricalPassword.class);
    }

    @Override
    public HistoricalPassword save(HistoricalPassword actualPassword) {
        return Mapper.map(this.historicalPasswordsRepository.save(Mapper.map(actualPassword, HistoricalPasswordsEntity.class)),HistoricalPassword.class);
    }

    @Override
    public void delete(List<Long> idToDelete) {
        this.historicalPasswordsRepository.deleteAllById(idToDelete);
    }
}

package co.com.events.postgres.repositories;

import co.com.events.models.domain.HistoricalPassword;
import co.com.events.postgres.entities.HistoricalPasswordsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricalPasswordsRepository  extends JpaRepository<HistoricalPasswordsEntity,Long> {
    boolean existsByUserIdAndPassword(Long userId, String password);

    List<HistoricalPasswordsEntity> findByUserId(Long userId);
}

package co.com.events.redis.adapter;

import co.com.events.models.domain.Attempt;
import co.com.events.models.repositories.IAttemptRepositoryPort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static co.com.events.models.enums.Constants.ATTEMPT;

@Service
@RequiredArgsConstructor
public class AttemptRepositoryAdapter implements IAttemptRepositoryPort {
    private final RedisTemplate<String, Attempt> redisTemplate;
    private ValueOperations<String,Attempt> valueOperations;
    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(Attempt attempt) {
        String finalKey = ATTEMPT.getValue().formatted(attempt.getUsername());
        valueOperations.set(finalKey, attempt);
        redisTemplate.expire(finalKey,10, TimeUnit.MINUTES);
    }

    @Override
    public Attempt find(String key) {
        String finalKey = ATTEMPT.getValue().formatted(key);
        return valueOperations.get(finalKey);
    }

    @Override
    public void delete(String key) {
        String finalKey = ATTEMPT.getValue().formatted(key);
        redisTemplate.delete(finalKey);
    }
}

package co.com.events.redis.adapter;

import co.com.events.models.domain.Code;
import co.com.events.models.repositories.ICodeRepositoryPort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class CodeRepositoryAdapter implements ICodeRepositoryPort {
    private final RedisTemplate<String,String> redisTemplate;
    private ValueOperations<String, String> valueOperations;

    @PostConstruct
    private void init() {
        valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(Code code) {
        valueOperations.set(code.getKey(), code.getCode());
        redisTemplate.expire(code.getKey(), 10, TimeUnit.MINUTES);
    }

    @Override
    public String findByKey(String key) {
        return valueOperations.get(key);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }
}

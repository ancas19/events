package co.com.events.redis.adapter;

import co.com.events.models.domain.Code;
import co.com.events.models.repositories.ICodeRepositoryPort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static co.com.events.models.enums.Constants.CODE;

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
        String finalkey=CODE.getValue().formatted(code.getKey());
        valueOperations.set(finalkey, code.getCode());
        redisTemplate.expire(finalkey, 10, TimeUnit.MINUTES);
    }

    @Override
    public String findByKey(String key) {
        String finalkey=CODE.getValue().formatted(key);
        return valueOperations.get(finalkey);
    }

    @Override
    public void delete(String key) {
        String finalkey=CODE.getValue().formatted(key);
        redisTemplate.delete(finalkey);
    }

    @Override
    public boolean verifyExists(String key) {
        String finalKey=CODE.getValue().formatted(key);
        String code = valueOperations.get(finalKey);
        return Objects.nonNull(code);
    }
}

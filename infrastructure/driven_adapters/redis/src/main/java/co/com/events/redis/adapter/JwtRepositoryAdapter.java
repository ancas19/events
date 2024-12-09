package co.com.events.redis.adapter;

import co.com.events.models.repositories.IJwtRepositoryPort;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static co.com.events.models.enums.Constants.JWT;


@Service
@RequiredArgsConstructor
public class JwtRepositoryAdapter  implements IJwtRepositoryPort {
    @Value("${jwt.expiration}")
    private Integer expirationTime;
    private final RedisTemplate<String, String> redisTemplate;
    private ValueOperations<String,String> valueOperations;
    @PostConstruct
    public void init() {
        valueOperations = redisTemplate.opsForValue();
    }


    @Override
    public void save(String key, String value) {
        String finalKey=JWT.getValue().formatted(key);
        valueOperations.set(finalKey, value);
        redisTemplate.expire(finalKey, expirationTime, TimeUnit.MINUTES);
    }

    @Override
    public String find(String key) {
        return this.valueOperations.get(JWT.getValue().formatted(key));
    }

    @Override
    public void delete(String key) {
        this.redisTemplate.delete(JWT.getValue().formatted(key));
    }
}

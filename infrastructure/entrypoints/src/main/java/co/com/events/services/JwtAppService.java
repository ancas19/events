package co.com.events.services;

import co.com.events.use_cases.jwt.JwtAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JwtAppService {
    private final JwtAdapter jwtAdapter;
    public String extractUsername(String token) {
        return jwtAdapter.extractUsername(token);
    }

    public List extractRoles(String token) {
        return jwtAdapter.extractRoles(token);
    }

    public boolean validateToken(String token) {
        return jwtAdapter.verifyToken(token);
    }
}

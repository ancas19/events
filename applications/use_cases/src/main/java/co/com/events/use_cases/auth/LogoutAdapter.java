package co.com.events.use_cases.auth;

import co.com.events.use_cases.interfaces.IUseCasesVoid;
import co.com.events.use_cases.jwt.JwtAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogoutAdapter implements IUseCasesVoid<String> {
    private final JwtAdapter jwtAdapter;

    @Override
    public void execute(String token) {
        jwtAdapter.deleteToken(token);
    }
}

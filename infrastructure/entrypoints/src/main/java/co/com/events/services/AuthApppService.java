package co.com.events.services;

import co.com.events.models.domain.AuthLogin;
import co.com.events.models.util.Mapper;
import co.com.events.request.AuthRequest;
import co.com.events.responses.AuthTokenResponse;
import co.com.events.use_cases.auth.LoginAdapter;
import co.com.events.use_cases.auth.LogoutAdapter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthApppService {
    private final LoginAdapter loginAdapter;
    private final LogoutAdapter logoutAdapter;

    public AuthTokenResponse login(AuthRequest authRequest) throws MessagingException, IOException {
        return Mapper.map(loginAdapter.execute(Mapper.map(authRequest, AuthLogin.class)),AuthTokenResponse.class);
    }

    public void logout(String token) {
        logoutAdapter.execute(token.substring(7));
    }
}

package co.com.events.controllers;

import co.com.events.request.AuthRequest;
import co.com.events.responses.AuthTokenResponse;
import co.com.events.responses.GeneralResponse;
import co.com.events.services.AuthApppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "Auth")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/auth")
public class AuthController {
    private final AuthApppService authAppService;

    @PostMapping("/login")
    ResponseEntity<GeneralResponse<AuthTokenResponse>> login(
            @Valid @RequestBody AuthRequest authRequest
    ) throws MessagingException, IOException {
        return ResponseEntity.ok(
                GeneralResponse.<AuthTokenResponse>builder()
                        .message("Login successful")
                        .response(authAppService.login(authRequest))
                        .build()
        );
    }

    @DeleteMapping("/logout")
    ResponseEntity<GeneralResponse<GeneralResponse<String>>> logout(
            @RequestHeader("Authorization") String token
    ) {
        authAppService.logout(token);
        return ResponseEntity.ok(
                GeneralResponse.<GeneralResponse<String>>builder()
                        .message("Logout successful")
                        .response(
                                GeneralResponse.<String>builder()
                                        .message("Logout successful")
                                        .response("Logout successful")
                                        .build()
                        )
                        .build()
        );
    }
}

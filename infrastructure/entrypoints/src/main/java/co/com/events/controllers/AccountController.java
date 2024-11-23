package co.com.events.controllers;

import co.com.events.models.enums.Messages;
import co.com.events.request.EmailRequest;
import co.com.events.responses.GeneralResponse;
import co.com.events.services.AccountAppService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountAppService accountAppService;
    @PostMapping("/username")
    public ResponseEntity<GeneralResponse<String>> verifyUsername(
            @Valid @RequestBody EmailRequest emailRequest
    ) {
        this.accountAppService.verifyUsername(emailRequest.getEmail());
        return ResponseEntity.ok(
                GeneralResponse.<String>builder()
                        .message(Messages.MESSAGE_USERNAME_AVAILABLE.getMessage())
                        .response(Messages.MESSAGE_USERNAME_AVAILABLE.getMessage())
                        .build()
        );
    }
}

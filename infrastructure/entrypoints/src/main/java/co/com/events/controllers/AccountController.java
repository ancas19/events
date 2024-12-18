package co.com.events.controllers;

import co.com.events.models.enums.Messages;
import co.com.events.request.AccountRequest;
import co.com.events.request.CodeVerificationRequest;
import co.com.events.request.EmailRequest;
import co.com.events.request.UsernameRequest;
import co.com.events.responses.GeneralResponse;
import co.com.events.services.AccountAppService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Account")
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1.0/accounts")
public class AccountController {
    private final AccountAppService accountAppService;

    @PostMapping()
    public ResponseEntity<GeneralResponse<String>> createAccount(
            @Valid @RequestBody AccountRequest accountRequest
    ) throws MessagingException {
        this.accountAppService.createAccount(accountRequest);
        return ResponseEntity.ok(
                GeneralResponse.<String>builder()
                        .message(Messages.MESSAGE_ACCOUNT_CREATED.getMessage())
                        .response(Messages.MESSAGE_ACCOUNT_CREATED.getMessage())
                        .build()
        );
    }


    @PostMapping("/username")
    public ResponseEntity<GeneralResponse<String>> verifyUsername(
            @Valid @RequestBody UsernameRequest usernameRequest
            ) {
        this.accountAppService.verifyUsername(usernameRequest.getUsername());
        return ResponseEntity.ok(
                GeneralResponse.<String>builder()
                        .message(Messages.MESSAGE_USERNAME_AVAILABLE.getMessage())
                        .response(Messages.MESSAGE_USERNAME_AVAILABLE.getMessage())
                        .build()
        );
    }

    @PostMapping("/email")
    public ResponseEntity<GeneralResponse<String>> sendVerifucationCode(
            @Valid @RequestBody EmailRequest emailRequest
    ) throws MessagingException {
        this.accountAppService.sendVerificationCode(emailRequest.getEmail());
        return ResponseEntity.ok(
                GeneralResponse.<String>builder()
                        .message(Messages.MESSAGE_VERIFICATION_CODE.getMessage())
                        .response(Messages.MESSAGE_VERIFICATION_CODE.getMessage())
                        .build()
        );
    }
}

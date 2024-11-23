package co.com.events.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmailVerificationRequest {
    @NotNull(message = "The email field is required")
    @NotEmpty(message = "The email field is required")
    @Email(message = "The email field is not valid")
    private String email;
    @NotNull(message = "The verificationCode field is required")
    @NotEmpty(message = "The verificationCode field is required")
    @Pattern(regexp = "^[0-9]+$", message = "The verificationCode field only accepts numbers")
    private String verificationCode;
}

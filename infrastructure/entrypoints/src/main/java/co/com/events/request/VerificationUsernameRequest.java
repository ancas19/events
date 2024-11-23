package co.com.events.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VerificationUsernameRequest {
    @NotNull(message = "The username field is required")
    @NotNull(message = "The username field is required")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "The username field only accepts letters and numbers")
    private String username;
}

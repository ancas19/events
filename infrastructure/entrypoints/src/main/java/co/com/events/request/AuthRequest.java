package co.com.events.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthRequest {
    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Username must contain only letters and numbers")
    private String username;
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$", message = "Password must contain at least 8 characters, one lowercase letter, one uppercase letter and one number")
    private String password;
}

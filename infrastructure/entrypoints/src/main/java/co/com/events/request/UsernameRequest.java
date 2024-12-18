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
public class UsernameRequest {
    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "Username must contain only letters and numbers")
    private String username;
}

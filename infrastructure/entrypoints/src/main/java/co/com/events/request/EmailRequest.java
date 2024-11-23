package co.com.events.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmailRequest {
    @NotNull(message = "The email field is required")
    @NotEmpty(message = "The email field is required")
    @Email(message = "The email field is not valid")
    private String email;
}

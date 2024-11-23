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
public class CreatePeopleRequest {
    @NotNull(message = "The names field is required")
    @NotEmpty(message = "The names field is required")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$", message = "The names field only accepts letters")
    private String names;
    @NotNull(message = "The lastNames field is required")
    @NotEmpty(message = "The lastNames field is required")
    @Pattern(regexp = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ ]+$", message = "The lastNames field only accepts letters")
    private String lastNames;
    @NotNull(message = "The phonenumber field is required")
    @NotEmpty(message = "The phonenumber field is required")
    @Pattern(regexp = "^[0-9]+$", message = "The phonenumber field only accepts numbers")
    private String phoneNumber;
    @NotNull(message = "The email field is required")
    @NotEmpty(message = "The email field is required")
    @Email(message = "The email field is not valid")
    private String email;
    @NotNull(message = "The username field is required")
    @NotNull(message = "The username field is required")
    @Pattern(regexp = "^[A-Z0-9]+$", message = "The username field only accepts letters and numbers")
    private String username;
    @NotNull(message = "The password field is required")
    @NotEmpty(message = "The password field is required")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must have at least one uppercase letter, one lowercase letter, one number and one special character")
    private String password;
    @NotNull(message = "The verifyPassword field is required")
    @NotEmpty(message = "The verifyPassword field is required")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must have at least one uppercase letter, one lowercase letter, one number and one special character")
    private String verifyPassword;
}

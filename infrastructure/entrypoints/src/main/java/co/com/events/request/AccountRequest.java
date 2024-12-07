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
public class AccountRequest {
    @NotNull(message = "Names are required")
    @NotEmpty(message = "Names are required")
    @Pattern(regexp = "^[A-ZÑÁÉÍÓÚ ]+$", message = "Names must contain only letters")
    private String names;
    @NotNull(message = "Surnames are required")
    @NotEmpty(message = "Surnames are required")
    @Pattern(regexp = "^[A-ZÑÁÉÍÓÚ ]+$", message = "Surnames must contain only letters")
    private String surnames;
    @NotNull(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;
    @NotNull(message = "Phone number is required")
    @NotEmpty(message = "Phone number is required")
    @Pattern(regexp = "^[0-9]{7,10}$", message = "Phone number must contain between 7 and 10 digits")
    private String phoneNumber;
    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Username must contain only letters and numbers")
    private String username;
    @NotNull(message = "Role is required")
    @NotEmpty(message = "Role is required")
    private String role;
    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$", message = "Password must contain at least 8 characters, one lowercase letter, one uppercase letter and one number")
    private String password;
    @NotNull(message = "Confirm password is required")
    @NotEmpty(message = "Confirm password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$", message = "Confirm password must contain at least 8 characters, one lowercase letter, one uppercase letter and one number")
    private String confirmPassword;
}

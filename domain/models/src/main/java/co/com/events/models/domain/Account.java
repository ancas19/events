package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Account {
    private String names;
    private String surnames;
    private String email;
    private String phoneNumber;
    private String username;
    private String role;
    private String password;
    private String confirmPassword;
    private String code;
}

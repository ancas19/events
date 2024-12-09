package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserLoginInformation  {
    private Long userId;
    private String username;
    private String email;
    private String changePassword;
    private String verifyemail;
    private Long personId;
    private String password;
    private String permissions;

}

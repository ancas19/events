package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private Long userId;
    private String username;
    private String email;
    private String verifyEmail;
    private String changePassword;
    private Long roleId;
    private Long personId;
}

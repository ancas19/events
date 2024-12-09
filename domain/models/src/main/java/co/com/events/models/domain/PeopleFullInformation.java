package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PeopleFullInformation {
    private Long personId;
    private String names;
    private String surnames;
    private String phoneNumber;
    private String username;
    private String role;
    private String email;
    private String verifyEmail;
    private String changePassword;
}

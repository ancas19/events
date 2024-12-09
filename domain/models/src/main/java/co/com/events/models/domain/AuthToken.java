package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class AuthToken {
    private String message;
    private String token;
    private PeopleFullInformation peopleFullInformation;
}

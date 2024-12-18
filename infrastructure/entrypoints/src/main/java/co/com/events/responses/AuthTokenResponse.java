package co.com.events.responses;

import co.com.events.models.domain.PeopleFullInformation;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthTokenResponse  implements Serializable {
    private String message;
    private String token;
    private PeopleFullInformation peopleFullInformation;
}

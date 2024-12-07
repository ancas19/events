package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class People {
    private Long personId;
    private String names;
    private String surnames;
    private String phoneNumber;
}

package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Roles {
    private Long roleId;
    private String name;
    private String description;
}

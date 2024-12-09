package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Attempt {
    private String username;
    private Integer quantity;
}

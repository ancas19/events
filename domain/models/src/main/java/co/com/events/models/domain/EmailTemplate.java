package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmailTemplate {
    private Long id;
    private String subject;
    private String body;
}

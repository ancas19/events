package co.com.events.models.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class HistoricalPassword {
    private Long historialId;
    private Long userId;
    private String password;
    private String active;
}

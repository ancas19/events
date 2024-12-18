package co.com.events.postgres.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historical_passwords")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HistoricalPasswordsEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_id")
    private Long historialId;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "value", nullable = false, length = 255)
    private String password;

    @Column(name = "active", nullable = false, length = 5)
    private String active;
}

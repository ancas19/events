package co.com.events.postgres.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PeopleEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "names", nullable = false, length = 255)
    private String names;

    @Column(name = "surnames", nullable = false, length = 255)
    private String surnames;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phoneNumber;
}

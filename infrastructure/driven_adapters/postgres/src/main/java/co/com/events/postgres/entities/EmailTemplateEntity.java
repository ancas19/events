package co.com.events.postgres.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "email_templates")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EmailTemplateEntity {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private Long id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "body")
    private String body;

}

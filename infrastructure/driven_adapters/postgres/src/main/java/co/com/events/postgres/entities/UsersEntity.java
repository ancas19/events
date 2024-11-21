package co.com.events.postgres.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UsersEntity extends AuditEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, length = 255)
    private String username;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "verify_email", nullable = false, length = 5)
    private String verifyEmail;

    @Column(name = "change_password", nullable = false, length = 5)
    private String changePassword;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Column(name = "person_id", nullable = false)
    private Long personId;
}

package co.com.events.postgres.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class AuditEntity {
    @Column(name = "created_user", nullable = false, updatable = false)
    private String userCreated;

    @Column(name = "updated_user")
    private String userUpdated;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PreUpdate
    public void preUpdateFunction(){
        this.updatedAt = LocalDateTime.now();
        this.userUpdated ="SYSTEM";
    }

    @PrePersist
    public void prePersistFunction(){
        this.createdAt = LocalDateTime.now();
        this.userCreated ="SYSTEM";
    }
}

package co.com.events.postgres.repositories;

import co.com.events.postgres.entities.EmailTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailTemplateReposiotry extends JpaRepository<EmailTemplateEntity, Long> {
    Optional<EmailTemplateEntity> findBySubject(String code);
}

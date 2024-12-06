package co.com.events.models.repositories;

import co.com.events.models.domain.EmailTemplate;

import java.util.Optional;

public interface IEmailTemplateRepositoryport {
    Optional<EmailTemplate> findBySubject(String code);
}

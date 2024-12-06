package co.com.events.postgres.adapter;

import co.com.events.models.domain.EmailTemplate;
import co.com.events.models.repositories.IEmailTemplateRepositoryport;
import co.com.events.models.util.Mapper;
import co.com.events.postgres.repositories.EmailTemplateReposiotry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmailTemplateRepositoryAdapter implements IEmailTemplateRepositoryport {
    private final EmailTemplateReposiotry emailTemplateReposiotry;
    @Override
    public Optional<EmailTemplate> findBySubject(String code) {
        return this.emailTemplateReposiotry.findBySubject(code)
                .map(template-> Mapper.map(template, EmailTemplate.class));
    }
}

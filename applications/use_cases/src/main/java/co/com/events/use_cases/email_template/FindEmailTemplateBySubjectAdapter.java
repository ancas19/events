package co.com.events.use_cases.email_template;

import co.com.events.models.domain.EmailTemplate;
import co.com.events.models.exceptions.NotFoundException;
import co.com.events.models.repositories.IEmailTemplateRepositoryport;
import co.com.events.use_cases.interfaces.IUseCases;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindEmailTemplateBySubjectAdapter implements IUseCases<String, EmailTemplate> {

    private final IEmailTemplateRepositoryport emailTemplateRepositoryport;

    @Override
    public EmailTemplate execute(String s) {
        Optional<EmailTemplate> emailTemplate = emailTemplateRepositoryport.findBySubject(s);
        if(emailTemplate.isEmpty()){
            throw new NotFoundException("Email template not found");
        }
        return emailTemplate.get();
    }
}

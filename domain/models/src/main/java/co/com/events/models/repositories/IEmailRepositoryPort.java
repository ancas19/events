package co.com.events.models.repositories;

import co.com.events.models.domain.Email;
import jakarta.mail.MessagingException;

public interface IEmailRepositoryPort {
    void sendEmail(Email email) throws MessagingException;
}

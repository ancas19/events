package co.com.events.email.adapter;

import co.com.events.models.domain.Email;
import co.com.events.models.repositories.IEmailRepositoryPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmailAdapter implements IEmailRepositoryPort {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;
    @Override
    public void sendEmail(Email email) throws MessagingException {
        MimeMessage message=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(message,true,"UTF-8");
        helper.setTo(email.getRecipient());
        helper.setSubject(email.getSubject());

        Context context=new Context();
        context.setVariable("body",email.getBody());
        String body=templateEngine.process("email",context);
        helper.setText(body,true);
        javaMailSender.send(message);
        log.info("Email sent to: {}",email);
    }
}

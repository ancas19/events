package co.com.events.use_cases.code;

import co.com.events.models.domain.Code;
import co.com.events.models.domain.Email;
import co.com.events.models.domain.EmailTemplate;
import co.com.events.models.repositories.ICodeRepositoryPort;
import co.com.events.models.repositories.IEmailRepositoryPort;
import co.com.events.use_cases.email_template.FindEmailTemplateBySubjectAdapter;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Random;

import static co.com.events.models.enums.Constants.EMAIL_VERIFICATION;
import static co.com.events.models.enums.Constants.VERIFY_CODE;

@RequiredArgsConstructor
@Slf4j
@Component
public class SendVerificationCodeAdapter implements IUseCasesVoid<String> {
    private final FindEmailTemplateBySubjectAdapter findEmailTemplateBySubjectAdapter;
    private final IEmailRepositoryPort emailRepositoryPort;
    private final ICodeRepositoryPort codeRepositoryPort;


    @Override
    public void execute(String email) throws MessagingException {
        String codeGenerated = generateCode();
        this.codeRepositoryPort.save(Code.builder().code(codeGenerated).key(email).build());
        EmailTemplate emailTemplate = findEmailTemplateBySubjectAdapter.execute(VERIFY_CODE.getValue());
        String body = emailTemplate.getBody().replace(":code", codeGenerated);
        emailRepositoryPort.sendEmail(
                Email.builder()
                        .body(body)
                        .recipient(email)
                        .subject(EMAIL_VERIFICATION.getValue())
                        .build()
        );
    }


    private String generateCode(){
        Random random = new Random();
        Integer code = 100000 + random.nextInt(900000);
        return code.toString();
    }
}

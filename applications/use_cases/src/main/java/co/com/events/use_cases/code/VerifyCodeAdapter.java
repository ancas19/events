package co.com.events.use_cases.code;

import co.com.events.models.domain.CodeVerification;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.repositories.ICodeRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import jakarta.mail.MessagingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

@AllArgsConstructor
@Slf4j
@Component
public class VerifyCodeAdapter implements IUseCasesVoid<CodeVerification> {
    private final ICodeRepositoryPort codeRepositoryPort;
    @Override
    public void execute(CodeVerification codeVerification) throws MessagingException {
        String codeFound=this.codeRepositoryPort.findByKey(codeVerification.getEmail());
        if(Objects.isNull(codeFound) || !codeFound.equals(codeVerification.getCode())){
            log.error("Code not found");
            throw new BadRequestException("Code is not valid");
        }
        this.codeRepositoryPort.delete(codeVerification.getEmail());
    }
}

package co.com.events.services;

import co.com.events.models.domain.CodeVerification;
import co.com.events.models.util.Mapper;
import co.com.events.request.CodeVerificationRequest;
import co.com.events.use_cases.code.SendVerificationCodeAdapter;
import co.com.events.use_cases.code.VerifyCodeAdapter;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import co.com.events.use_cases.users.VerifyUsernameAdapter;
import jakarta.mail.MessagingException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class AccountAppService {
    private final VerifyUsernameAdapter verifyUsernameAdapter;
    private final SendVerificationCodeAdapter sendVerificationCodeAdapter;
    private final VerifyCodeAdapter verifyCodeAdapter;

    @Transactional(value ="eventsTransactionManager" ,rollbackFor = Exception.class)
    public void verifyUsername(String username) {
        this.verifyUsernameAdapter.execute(username);
    }

    @Transactional(value ="eventsTransactionManager" ,rollbackFor = Exception.class)
    public void sendVerificationCode(String email) throws MessagingException {
        this.sendVerificationCodeAdapter.execute(email);
    }

    @Transactional(value ="eventsTransactionManager" ,rollbackFor = Exception.class)
    public void verifyCode(CodeVerificationRequest codeVerificationRequest) throws MessagingException {
        this.verifyCodeAdapter.execute(Mapper.map(codeVerificationRequest, CodeVerification.class));
    }

}

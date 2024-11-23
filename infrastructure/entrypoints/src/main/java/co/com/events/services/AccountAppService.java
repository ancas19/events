package co.com.events.services;

import co.com.events.use_cases.interfaces.IUseCasesVoid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountAppService {
    private final IUseCasesVoid<String> verifyUsernameAdapter;

    public AccountAppService(IUseCasesVoid<String> verifyUsernameAdapter) {
        this.verifyUsernameAdapter = verifyUsernameAdapter;
    }

    @Transactional(value ="eventsTransactionManager" ,rollbackFor = Exception.class)
    public void verifyUsername(String username) {
        this.verifyUsernameAdapter.execute(username);
    }
}

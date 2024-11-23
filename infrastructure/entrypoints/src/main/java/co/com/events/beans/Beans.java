package co.com.events.beans;

import co.com.events.models.repositories.IUserRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import co.com.events.use_cases.users.VerifyUsernameAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    public IUseCasesVoid<String> verifyUsernameAdapter(IUserRepositoryPort userRepositoryPort) {
        return new VerifyUsernameAdapter(userRepositoryPort);
    }
}

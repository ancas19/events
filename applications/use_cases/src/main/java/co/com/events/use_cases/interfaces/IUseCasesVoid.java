package co.com.events.use_cases.interfaces;

import jakarta.mail.MessagingException;

@FunctionalInterface
public interface IUseCasesVoid<INPUT> {
    void execute(INPUT input) throws MessagingException;
}

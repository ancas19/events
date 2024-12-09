package co.com.events.use_cases.interfaces;

import jakarta.mail.MessagingException;

import java.io.IOException;

@FunctionalInterface
public interface IUseCases<INPUT,OUTPUT> {
    OUTPUT execute(INPUT input) throws MessagingException, IOException;
}

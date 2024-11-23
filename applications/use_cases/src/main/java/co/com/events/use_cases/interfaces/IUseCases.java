package co.com.events.use_cases.interfaces;

@FunctionalInterface
public interface IUseCases<INPUT,OUTPUT> {
    OUTPUT execute(INPUT input);
}

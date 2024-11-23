package co.com.events.use_cases.interfaces;

@FunctionalInterface
public interface IUseCasesVoid<INPUT> {
    void execute(INPUT input);
}

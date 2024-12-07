package co.com.events.use_cases.passwords;

import co.com.events.models.domain.HistoricalPassword;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.models.repositories.IHistoricalPasswordsRepositoryPort;
import co.com.events.use_cases.interfaces.IUseCases;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static co.com.events.models.enums.Constants.NO;

@Component
@RequiredArgsConstructor
public class CreatePasswordAdapter  implements IUseCasesVoid<HistoricalPassword> {
    private final IHistoricalPasswordsRepositoryPort historicalPasswordRepositoryPort;
    @Override
    public void execute(HistoricalPassword s) {
        if (historicalPasswordRepositoryPort.verifyExistsPassword(s.getUserId(), s.getPassword())) {
            throw new BadRequestException(Messages.MESSAGE_PASSWORD_ALREADY_EXISTS.getMessage());
        }
        List<HistoricalPassword> userPasswords = historicalPasswordRepositoryPort.findPasswordByUserId(s.getUserId());
        if (!userPasswords.isEmpty()) {
            deactivateCurrentPassword(userPasswords);
            deleteExcessPasswords(userPasswords);
        }
        historicalPasswordRepositoryPort.save(s);
    }
    private void deactivateCurrentPassword(List<HistoricalPassword> userPasswords) {
        HistoricalPassword currentPassword = userPasswords.get(0);
        currentPassword.setActive(NO.getValue());
        historicalPasswordRepositoryPort.save(currentPassword);
    }

    private void deleteExcessPasswords(List<HistoricalPassword> userPasswords) {
        // Skip the first 4 recent passwords and delete the rest
        List<Long> idsToDelete = userPasswords.stream()
                .skip(4)
                .map(HistoricalPassword::getHistorialId)
                .toList();
        if (!idsToDelete.isEmpty()) {
            historicalPasswordRepositoryPort.delete(idsToDelete);
        }
    }
}

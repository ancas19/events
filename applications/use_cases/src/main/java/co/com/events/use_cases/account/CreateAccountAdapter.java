package co.com.events.use_cases.account;

import co.com.events.models.domain.*;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.BadRequestException;
import co.com.events.use_cases.interfaces.IUseCasesVoid;
import co.com.events.use_cases.passwords.CreatePasswordAdapter;
import co.com.events.use_cases.people.CreatePeopleAdapter;
import co.com.events.use_cases.roles.FindRoleByNameAdapter;
import co.com.events.use_cases.users.CreateUserAdapter;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static co.com.events.models.enums.Constants.NO;
import static co.com.events.models.enums.Constants.SI;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateAccountAdapter implements IUseCasesVoid<Account> {
    private final FindRoleByNameAdapter findRoleByNameAdapter;
    private final CreatePeopleAdapter createPeopleAdapter;
    private  final CreateUserAdapter createUserAdapter;
    private final CreatePasswordAdapter createPasswordAdapter;
    @Override
    public void execute(Account account) throws MessagingException {
        if(!account.getPassword().equals(account.getConfirmPassword())){
            log.error("Passwords do not match");
            throw new BadRequestException(Messages.MESSAGE_PASSWORDS_DO_NOT_MATCH.getMessage());
        }
        People peopleCreated= createPeopleAdapter.execute(
                People.builder()
                        .names(account.getNames())
                        .surnames(account.getSurnames())
                        .phoneNumber(account.getPhoneNumber())
                        .build()
        );
        Roles rolesFound= findRoleByNameAdapter.execute(account.getRole());
        User userCreated= createUserAdapter.execute(
                User.builder()
                        .username(account.getUsername())
                        .personId(peopleCreated.getPersonId())
                        .email(account.getEmail())
                        .roleId(rolesFound.getRoleId())
                        .verifyEmail(NO.getValue())
                        .changePassword(NO.getValue())
                        .build()
        );
        this.createPasswordAdapter.execute(
                HistoricalPassword.builder()
                        .active(SI.getValue())
                        .userId(userCreated.getUserId())
                        .password(account.getPassword())
                        .build()
        );
    }
}

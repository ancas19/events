package co.com.events.use_cases.users;

import co.com.events.models.domain.User;
import co.com.events.models.domain.UserLoginInformation;
import co.com.events.models.enums.Messages;
import co.com.events.models.exceptions.UnauthorizedException;
import co.com.events.models.repositories.IUserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

import static co.com.events.models.enums.Constants.SI;

@Component
@RequiredArgsConstructor
public class UserDetailsAdapter implements UserDetailsService {
    private final IUserRepositoryPort userRepositoryPort;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserLoginInformation> userFound=userRepositoryPort.findUserByUsernameOrEmail(username);
        if(userFound.isEmpty()){
            throw new UnauthorizedException(Messages.MESSAGE_USER_NOT_FOUND.getMessage());
        }
        if(userFound.get().getVerifyemail().equals(SI.getValue())){
            throw new UnauthorizedException(Messages.MESSAGE_EMAIL_NOT_VERIFIED.getMessage());
        }
        return new org.springframework.security.core.userdetails.User(userFound.get().getUsername(), userFound.get().getPassword(), getAuthority(userFound.get()));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserLoginInformation user) {
        return user.getPermissions().stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());

    }
}

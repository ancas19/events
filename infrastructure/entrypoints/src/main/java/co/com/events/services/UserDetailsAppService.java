package co.com.events.services;

import co.com.events.use_cases.users.UserDetailsAdapter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsAppService {
    private final UserDetailsAdapter userDetailsAdapter;

    public UserDetails loadUserByUsername(String username) {
        return userDetailsAdapter.loadUserByUsername(username);
    }
}

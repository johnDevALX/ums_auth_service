package net.ekene.ums_auth_service.config.security;

import lombok.RequiredArgsConstructor;
import net.ekene.model.UserData;
import net.ekene.ums_auth_service.repository.UserDataRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserDataRepository userDataRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> user = userDataRepository.findUserDataByEmailIgnoreCase(username);
        return user.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
    }
}

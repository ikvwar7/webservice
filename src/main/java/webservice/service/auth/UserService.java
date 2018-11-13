package webservice.service.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import webservice.domain.auth.Role;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        // Со встроенным userom
//        UserDetails user = User.builder()
//                .username("user")
//                .password("123")
//                .passwordEncoder(p -> new BCryptPasswordEncoder().encode(p))
//                .authorities(Collections.singletonList(Role.USER))
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();

        return User.builder()
                .username("user")
                .password("123")
                .passwordEncoder(p -> new BCryptPasswordEncoder().encode(p))
                .authorities(Collections.singletonList(Role.USER))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}


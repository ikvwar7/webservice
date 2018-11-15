package webservice.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import webservice.dao.auth.UserRepository;
import webservice.domain.User;
import webservice.domain.auth.Role;

import javax.annotation.PostConstruct;

import java.util.Collections;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        checkNotNull(userRepository);
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        if (userRepository.findByName("user").isPresent() == false) {
            userRepository.save(User.builder()
                    .username("user")
                    .password(passwordEncoder().encode("123"))
                    .authorities(Collections.singletonList(Role.USER))
                    .credentialsNonExpired(true)
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .isEnabled(true)
                    .build());
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByName(s).get();
//                orElseThrow(()->new UsernameNotFoundException("User it found"));

//        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        // Со встроенным userom
//        UserDetails user = User.builder()
//                .username("user")
//                .password("123")
//                .passwordEncoder(p -> passwordEncoder.encode(p))
//                .authorities(Collections.singletonList(Role.USER))
//                .accountExpired(false)
//                .accountLocked(false)
//                .credentialsExpired(false)
//                .disabled(false)
//                .build();
//        return user;
    }
}


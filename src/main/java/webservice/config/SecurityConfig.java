package webservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import webservice.service.auth.UserService;

import static com.google.common.base.Preconditions.checkNotNull;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    //.loginPage("/login.html")
                    .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll();
    }

    @Autowired
    public SecurityConfig(UserService userService) {
        checkNotNull(userService);
        this.userService = userService;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}

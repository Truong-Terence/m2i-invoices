package com.tp.biller.security;

import com.tp.biller.services.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{


    @Bean
    UserDetailsService customUserDetailsService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService());
        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        return http
                .authorizeHttpRequests(requests -> {
                    requests
                            .requestMatchers("/login").permitAll()
                            .anyRequest().authenticated();
                })
                .formLogin(form -> {
                    form
//                            .loginPage("/login") // indique que je souhaite utiliser mon propre thymeleaf
                            .usernameParameter("email") // <input name = "email"
                            .passwordParameter("password") // <input name = "password"
                            .permitAll()
                            .defaultSuccessUrl("/dashboard");
                })
                .logout(logout -> {
                    logout
                            .logoutUrl("/logout");
                })
                .build();
    }
}

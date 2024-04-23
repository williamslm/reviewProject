package com.udacity.jwdnd.c1.review.config;

import com.udacity.jwdnd.c1.review.service.AuthenticationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private AuthenticationService authProvider;

    public SecurityConfig(AuthenticationService authProvider) {
        this.authProvider = authProvider;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(authProvider);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests((authorize) -> authorize
                        .requestMatchers("signup","/css/**","/js/**").permitAll()
                        .anyRequest().authenticated()
                );

        http
                .formLogin(form -> form
                .loginPage("/login")
                .permitAll().defaultSuccessUrl("/chat",true)
        );

        return http.build();
    }
}
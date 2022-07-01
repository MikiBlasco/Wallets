package com.example.wallets.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws  Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/all-users").permitAll()
                .mvcMatchers(HttpMethod.GET, "/user/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/create-user").permitAll()
                .mvcMatchers(HttpMethod.PATCH, "/update-user/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/delete-user/**").permitAll()
                .mvcMatchers(HttpMethod.POST, "/add-wallet").permitAll()
                .mvcMatchers(HttpMethod.PATCH, "/modify-amount/**").permitAll()
                .anyRequest().permitAll();

        http.csrf().disable();
        return http.build();

    }
}

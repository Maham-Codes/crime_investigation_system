package com.crimeinvestigation.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // In-memory user with INVESTIGATOR role
        UserDetails investigator = User.builder()
                .username("investigator1")  // You will use this username to login
                .password(passwordEncoder().encode("password"))  // This is the password
                .roles("INVESTIGATOR")  // This must match the role check in the endpoint
                .build();

        return new InMemoryUserDetailsManager(investigator);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Encrypts passwords securely
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disable CSRF for APIs
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cases/update-status/**").hasRole("INVESTIGATOR")  // 🔒 Protected path
                        .anyRequest().permitAll()  // Allow other paths for now
                )
                .httpBasic();  // Use basic auth for now (you can use .formLogin() for UI)

        return http.build();
    }
}


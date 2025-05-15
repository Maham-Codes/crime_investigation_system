package com.crimeinvestigation.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails investigator = User.builder()
                .username("investigator1") // Username for investigator
                .password(passwordEncoder().encode("password"))
                .roles("INVESTIGATOR")
                .build();

        UserDetails regularUserOne = User.builder()
                .username("user1") // Original dummy user
                .password(passwordEncoder().encode("userpass"))
                .roles("USER")
                // .authorities("ROLE_USER") // Another way to assign roles
                .build();

        // Add your new dummy user
        UserDetails aliKhanUser = User.builder()
                .username("alikhan95@gmail.com") // Using email as username, common practice
                .password(passwordEncoder().encode("pass123")) // Encode the password
                .roles("USER") // Assign a USER role
                .build();

        return new InMemoryUserDetailsManager(investigator, regularUserOne, aliKhanUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .httpBasic(AbstractHttpConfigurer::disable)
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                );
        return http.build();
    }
}
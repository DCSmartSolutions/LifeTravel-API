package com.nexusnova.lifetravelapi.app.shared.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(withDefaults())
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                );
        return http.build();
    }

    /*
    @Bean
    public FirebaseAuthenticationFilter firebaseAuthenticationFilter(Environment environment) {
        return new FirebaseAuthenticationFilter(environment);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, Environment environment) throws Exception {
        http.addFilterBefore(firebaseAuthenticationFilter(environment), BasicAuthenticationFilter.class);
        http.csrf((AbstractHttpConfigurer::disable)).cors(AbstractHttpConfigurer::disable);
        return http.build();
    }
     */
}
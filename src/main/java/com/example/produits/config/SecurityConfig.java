package com.example.produits.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        log.info("Configuration de Spring Security: Toutes les requêtes sont autorisées");
        
        http
                .csrf().disable()  // Désactiver CSRF (utile pour les tests)
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()  // Autoriser toutes les requêtes
                )
                .formLogin().disable()  // Désactiver le formulaire de connexion par défaut
                .httpBasic().disable();  // Désactiver l'authentification HTTP Basic

        return http.build();
    }
}

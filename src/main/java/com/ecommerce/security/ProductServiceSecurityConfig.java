package com.ecommerce.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecommerce.security.internal.InternalJwtAuthFilter;

@Configuration
public class ProductServiceSecurityConfig {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceSecurityConfig.class);

    @Bean
    SecurityFilterChain apiSecurity(HttpSecurity http,
                                    ObjectProvider<InternalJwtAuthFilter> jwtFilterProvider) throws Exception {

        InternalJwtAuthFilter filter = jwtFilterProvider.getIfAvailable();
        if (filter == null) {
            log.warn("InternalJwtAuthFilter bean missing - will skip JWT authentication");
        } else {
            log.info("InternalJwtAuthFilter bean found; will be added to chain");
        }

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/actuator/health", "/actuator/info").permitAll()
                .requestMatchers("/api/v1/product/**").authenticated()
                .anyRequest().denyAll()
            );

        if (filter != null) {
            http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        }

        return http.build();
    }
}
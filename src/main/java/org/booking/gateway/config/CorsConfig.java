package org.booking.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Collections;
import java.util.List;

@Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        return exchange -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Collections.singletonList(exchange.getRequest().getHeaders().getOrigin()));
            config.setAllowedMethods(List.of("POST", "GET", "OPTIONS", "PUT", "DELETE", "PATCH", "HEAD"));
            config.setAllowedHeaders(List.of("Origin", "Content-Length", "Content-Type", "Authorization"));
            config.setAllowCredentials(true);
            return config;
        };
    }
}

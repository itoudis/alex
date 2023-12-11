package com.itoudis.alex.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        List<RequestMatcher> defaultPublicEndpoints = new ArrayList<>();
        defaultPublicEndpoints.add(new AntPathRequestMatcher("/api/**/auth/**"));
        defaultPublicEndpoints.add(new AntPathRequestMatcher("/actuator/**"));
        defaultPublicEndpoints.add(new AntPathRequestMatcher("/swagger-ui.html"));
        defaultPublicEndpoints.add(new AntPathRequestMatcher("/**/v3/api-docs/**"));
        defaultPublicEndpoints.add(new AntPathRequestMatcher("/swagger-ui/**"));



        http.authorizeRequests()
                .requestMatchers("/**").hasRole("USER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin();
        return http.build();

    }

}

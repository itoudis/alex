package com.itoudis.alex.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityConfiguration {

    private DevelopmentAuthenticationProvider developmentAuthenticationProvider;

    public SecurityConfiguration(DevelopmentAuthenticationProvider developmentAuthenticationProvider) {
        this.developmentAuthenticationProvider = developmentAuthenticationProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(){
        return new ProviderManager(developmentAuthenticationProvider);
    }

    // TODO ne işlemi olduğu araştırılacak
    @Bean
    public SecurityContextRepository securityContextRepository(){
        return new DelegatingSecurityContextRepository(new RequestAttributeSecurityContextRepository(), new HttpSessionSecurityContextRepository());
    }

}

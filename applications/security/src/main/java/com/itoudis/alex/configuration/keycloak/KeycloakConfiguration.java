package com.itoudis.alex.configuration.keycloak;


import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfiguration {

    @Value("${keycloak.auth-server-url}")
    private String keycloakServerUrl;

    @Bean
    public Keycloak getKeycloakAdminClient() {
        String serverUrl = "http://localhost:8791";
        String realm = "master"; // or your desired realm
        String username = "admin";
        String password = "admin";
        String clientId = "admin-cli";

        return KeycloakBuilder.builder()
                .serverUrl(serverUrl)
                .realm(realm)
                .username(username)
                .password(password)
                .clientId(clientId)
                .build();
    }
}
package com.itoudis.alex.configuration.keycloak;

import jakarta.annotation.PostConstruct;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.RealmRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeycloakRealmInitializer {
    private final Keycloak keycloakAdminClient;

    @Autowired
    public KeycloakRealmInitializer(Keycloak keycloakAdminClient) {
        this.keycloakAdminClient = keycloakAdminClient;
    }

    @PostConstruct
    public void createKeycloakRealm() {
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setId("your_realm_id");
        realmRepresentation.setRealm("your_realm_name");
        realmRepresentation.setEnabled(true);

        keycloakAdminClient.realms().create(realmRepresentation);
     }
}

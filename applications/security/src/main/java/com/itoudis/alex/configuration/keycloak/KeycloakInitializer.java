package com.itoudis.alex.configuration.keycloak;

import com.itoudis.alex.configuration.DefaultUsers;
import com.itoudis.alex.domain.user.Role;
import com.itoudis.alex.domain.user.User;
import com.itoudis.alex.infra.configuration.Profiles;
import jakarta.annotation.PostConstruct;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile({Profiles.DEVELOPMENT})
public class KeycloakInitializer {
    private final Keycloak keycloakAdminClient;
    
    private static final String realmName = "alex_realm";
    private static final String clientId = "alex_client_id";

    @Autowired
    public KeycloakInitializer(Keycloak keycloakAdminClient) {
        this.keycloakAdminClient = keycloakAdminClient;
    }

    @PostConstruct
    public void initKeycloak() {
        if (isRealmExists()) {
            dropRealm();
        }
        createKeycloakRealm();
        createKeycloakClient();
        createKeycloakRoles();
        createKeycloakUsers();
        mapRoles();
    }

    private void createKeycloakRealm() {
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setId("productId");
        realmRepresentation.setRealm(realmName);
        realmRepresentation.setEnabled(true);

        keycloakAdminClient.realms().create(realmRepresentation);
    }


    private void createKeycloakClient() {
        ClientRepresentation clientRepresentation = new ClientRepresentation();
        clientRepresentation.setClientId(clientId);
        clientRepresentation.setProtocol("openid-connect");
        clientRepresentation.setRedirectUris(List.of("http://localhost:8791"));
        clientRepresentation.setWebOrigins(List.of("http://localhost:8791"));

        keycloakAdminClient.realm(realmName).clients().create(clientRepresentation);
    }

    private void createKeycloakRoles() {
        for (Role role : Role.values()) {
            RoleRepresentation roleRepresentation = new RoleRepresentation();
            roleRepresentation.setName(role.name());
            roleRepresentation.setClientRole(false);

            keycloakAdminClient.realm(realmName).roles().create(roleRepresentation);
        }
    }

    private void createKeycloakUsers() {
        for (User user : DefaultUsers.getDefaultUsers()) {
            UserRepresentation userRepresentation = new UserRepresentation();
            userRepresentation.setUsername(user.getUsername());
            userRepresentation.setEmail(user.getEmail());
            userRepresentation.setEnabled(true);

            //TODO : 'Response' used without 'try'-with-resources statement
            keycloakAdminClient.realm(realmName).users().create(userRepresentation);
        }
    }



    private boolean isRealmExists() {
        return keycloakAdminClient.realms().findAll().stream()
                .anyMatch(realmRepresentation -> realmRepresentation.getRealm().equals(realmName));
    }

    private void dropRealm() {
        keycloakAdminClient.realm(realmName).remove();
    }

    private void mapRoles() {
        DefaultUsers.getDefaultUsers().forEach(user -> {
            UserRepresentation userRepresentation = keycloakAdminClient.realm(realmName).users().search(user.getUsername()).get(0);
            List<RoleResource> roleResources = findRoles(user.getRoles());

            roleResources.forEach(roleResource -> {
                keycloakAdminClient.realm(realmName).users().get(userRepresentation.getId()).roles().realmLevel().add(List.of(roleResource.toRepresentation()));
            });
        });
    }

    private List<RoleResource> findRoles(List<Role> roles) {
        List<RoleResource> roleResources = new ArrayList<>();

        roles.forEach(role -> {
            roleResources.add(keycloakAdminClient.realm(realmName).roles().get(role.name()));
        });
        return roleResources;
    }
}

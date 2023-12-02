package com.itoudis.alex.configuration.keycloak;

import com.itoudis.alex.configuration.DefaultUsers;
import com.itoudis.alex.domain.user.Role;
import com.itoudis.alex.domain.user.User;
import jakarta.annotation.PostConstruct;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RoleResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.RealmRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeycloakInitializer {
    private final Keycloak keycloakAdminClient;

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
    }

    private void createKeycloakRealm() {
        RealmRepresentation realmRepresentation = new RealmRepresentation();
        realmRepresentation.setId("your_realm_id");
        realmRepresentation.setRealm("your_realm_name");
        realmRepresentation.setEnabled(true);

        keycloakAdminClient.realms().create(realmRepresentation);
    }


    private void createKeycloakClient() {
        ClientRepresentation clientRepresentation = new ClientRepresentation();
        clientRepresentation.setClientId("your_client_id");
        clientRepresentation.setProtocol("openid-connect");
        clientRepresentation.setRedirectUris(List.of("http://localhost:8791"));
        clientRepresentation.setWebOrigins(List.of("http://localhost:8791"));

        keycloakAdminClient.realm("your_realm_name").clients().create(clientRepresentation);
    }

    private void createKeycloakRoles() {
        for (Role role : Role.values()) {
            RoleRepresentation roleRepresentation = new RoleRepresentation();
            roleRepresentation.setName(role.name());
            roleRepresentation.setClientRole(false);

            keycloakAdminClient.realm("your_realm_name").roles().create(roleRepresentation);
        }
    }

    private void createKeycloakUsers() {
        for (User user : DefaultUsers.getDefaultUsers()) {
            UserRepresentation userRepresentation = new UserRepresentation();
            userRepresentation.setUsername(user.getUsername());
            userRepresentation.setEmail(user.getEmail());
            userRepresentation.setEnabled(true);
            userRepresentation.setRealmRoles(user.getRoles());

            //TODO : 'Response' used without 'try'-with-resources statement
            keycloakAdminClient.realm("your_realm_name").users().create(userRepresentation);
        }
    }



    private boolean isRealmExists() {
        return keycloakAdminClient.realms().findAll().stream()
                .anyMatch(realmRepresentation -> realmRepresentation.getRealm().equals("your_realm_name"));
    }

    private void dropRealm() {
        keycloakAdminClient.realm("your_realm_name").remove();
    }

    private void mapRoles() {
        //user ve roller alınacak
        //alınan userın defalt user içerisinde karşılığı bulunacak
        //bulunan userin rollerini kc karşılığı bulunacak
        //kc tarafındaki usera bu roller atanacak
        //
        //
    }

    private List<RoleResource> findRoles(List<Role> roles) {
        List<RoleResource> roleResources = new ArrayList<>();

        roles.forEach(role -> {
            roleResources.add(keycloakAdminClient.realm("your_realm_name").roles().get(role.name()));
        });
        return roleResources;
    }
}

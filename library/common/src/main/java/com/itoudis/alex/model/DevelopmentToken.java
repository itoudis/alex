package com.itoudis.alex.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class DevelopmentToken extends AbstractAuthenticationToken {
    private String username;

    public DevelopmentToken(String username) {
        super(null);
        this.username = username;
        super.setAuthenticated(false);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return username;
    }

}


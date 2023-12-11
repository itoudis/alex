package com.itoudis.alex.model;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedToken extends AbstractAuthenticationToken {
    private UserDetails user;

    public AuthenticatedToken(UserDetails user) {
        super(user.getAuthorities());
        this.user = user;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

}


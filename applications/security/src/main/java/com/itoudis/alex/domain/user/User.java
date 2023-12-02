package com.itoudis.alex.domain.user;

import java.util.List;

public class User {
    private final String username;
    private final String email;
    private final List<String> roles;

    public User(String username, String email, List<String> roles) {
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }
}

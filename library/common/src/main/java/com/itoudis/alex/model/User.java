package com.itoudis.alex.model;

import java.util.List;

public class User {
    private final Long id;
    private final String username;
    private final String email;
    private final List<Role> roles;

    public User(Long id, String username, String email, List<Role> roles) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }
}

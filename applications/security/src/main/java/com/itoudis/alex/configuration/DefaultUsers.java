package com.itoudis.alex.configuration;

import com.itoudis.alex.model.Role;
import com.itoudis.alex.model.User;

import java.util.List;

public class DefaultUsers {

    private static final List<User> DEFAULT_USERS = List.of(
            new User(1L,"emre", "emre@email.com", List.of(Role.ROLE_ADMIN)),
            new User(2L,"huseyinberk", "huseyinberk@email.com",  List.of(Role.ROLE_USER))
    );

    public static List<User> getDefaultUsers() {
        return DEFAULT_USERS;
    }
}

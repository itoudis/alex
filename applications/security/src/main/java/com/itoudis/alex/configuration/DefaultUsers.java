package com.itoudis.alex.configuration;

import com.itoudis.alex.domain.user.Role;
import com.itoudis.alex.domain.user.User;

import java.util.List;

public class DefaultUsers {

    private static final List<User> DEFAULT_USERS = List.of(
            new User("emre", "emre@email.com", List.of(Role.ROLE_ADMIN.name())),
            new User("huseyinberk", "huseyinberk@email.com",  List.of(Role.ROLE_USER.name()))
    );

    public static List<User> getDefaultUsers() {
        return DEFAULT_USERS;
    }
}

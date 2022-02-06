package com.mycompany.auth;

import java.security.Principal;
import java.util.Set;

public class User implements Principal {
    private final String name;
    private final String password;

    private final Set<String> roles;

    public User(String name) {
        this.name = name;
        this.password = null;
        this.roles = null;
    }

    public User(String name, String password, Set<String> roles) {
        this.name = name;
        this.password = null;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return (int) (Math.random() * 100);
    }

    public Set<String> getRoles() {
        return roles;
    }
}
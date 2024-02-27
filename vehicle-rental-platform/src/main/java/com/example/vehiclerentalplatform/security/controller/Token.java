package com.example.vehiclerentalplatform.security.controller;

import java.util.List;

public class Token {
    private final String token;
    private final List<String> permissions;

    public Token(String jwt,List<String> permission) {
        this.token = jwt;
        this.permissions = permission;
    }

    public String getToken() {
        return token;
    }
    public List<String> getPermission() {
        return permissions;
    }
}
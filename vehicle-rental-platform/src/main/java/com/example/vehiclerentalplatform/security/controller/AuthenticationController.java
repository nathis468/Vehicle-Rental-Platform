package com.example.vehiclerentalplatform.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalplatform.security.model.LoginRequest;
import com.example.vehiclerentalplatform.security.model.UserEntity;
import com.example.vehiclerentalplatform.security.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/auth")
@RequiredArgsConstructor
@CrossOrigin()
public class AuthenticationController { 
    @Autowired
    private AuthenticationService service;

    @PostMapping("/register")
    public Token register(@RequestBody UserEntity request){
        Token token =  service.register(request);
        return token;
    }

    @PostMapping("/login")
    public Token authenticate(@RequestBody LoginRequest request){  
        Token token = service.authenticate(request);
        return token;
    }
}
package com.example.vehiclerentalplatform.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.model.UserPermissions;
import com.example.vehiclerentalplatform.security.controller.Token;
import com.example.vehiclerentalplatform.security.model.LoginRequest;
import com.example.vehiclerentalplatform.security.model.Role;
import com.example.vehiclerentalplatform.security.model.UserEntity;
import com.example.vehiclerentalplatform.security.repository.UserEntityRepository;
import com.example.vehiclerentalplatform.service.PermissionUpdateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    // private final RolesRepository rolesRepo;

    private final UserEntityRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;
    
    private final AuthenticationManager authenticationManager;

    private final PermissionUpdateService permissionUpdateService;

    public Token register(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (userRepo.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        if(user.getRole() == null){
            user.setRole(Role.USER);
        }

        userRepo.save(user);
        permissionUpdateService.addNewUserPermissionsFromUserEntity(user);
        
        String jwt = jwtService.generateToken(user);
        Token token = new Token(jwt,new ArrayList<>());
        return token;
    }


    public Token authenticate(LoginRequest request) {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        }
        catch(Exception e){
            throw new BadCredentialsException("Invalid Credentials");
        }
        UserEntity user = userRepo.findByEmail(request.getEmail()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        Token token = new Token(jwt, permissionUpdateService.getPermissions(user));
        return token;
    }
}

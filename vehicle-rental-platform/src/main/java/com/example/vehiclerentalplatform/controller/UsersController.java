package com.example.vehiclerentalplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalplatform.dto.Users;
import com.example.vehiclerentalplatform.service.UsersService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/users")
@CrossOrigin()
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping("")
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<>(usersService.getAllUsers(),HttpStatus.OK);
    }
    
}

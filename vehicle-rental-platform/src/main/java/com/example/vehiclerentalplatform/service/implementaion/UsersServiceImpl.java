package com.example.vehiclerentalplatform.service.implementaion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.dto.Users;
import com.example.vehiclerentalplatform.security.model.UserEntity;
import com.example.vehiclerentalplatform.security.repository.UserEntityRepository;
import com.example.vehiclerentalplatform.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
    @Autowired
    private UserEntityRepository userEntityRepo;

 @Override
public List<Users> getAllUsers() {
    return userEntityRepo.findAll().stream().map(userEntity -> new Users(userEntity.getUsername(), userEntity.getEmail()))  .collect(Collectors.toList());
}

}

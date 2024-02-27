package com.example.vehiclerentalplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.vehiclerentalplatform.model.UserPermissions;
import java.util.List;
import com.example.vehiclerentalplatform.security.model.UserEntity;


@Repository 
public interface UserPermissionsRepository extends MongoRepository<UserPermissions,String>{
    UserPermissions findByUser(UserEntity user);
}

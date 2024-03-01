package com.example.vehiclerentalplatform.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vehiclerentalplatform.model.Bookings;
import java.util.List;


public interface BookingsRepository extends MongoRepository<Bookings,String>{
    List<Bookings> findByEmail(String email);
}

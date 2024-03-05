package com.example.vehiclerentalplatform.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.vehiclerentalplatform.model.Bookings;
import java.util.List;


public interface BookingsRepository extends MongoRepository<Bookings,String>{
    List<Bookings> findByEmail(String email);
    Page<Bookings> findByEmail(String email, PageRequest pageRequest);
}

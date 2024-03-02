package com.example.vehiclerentalplatform.service.implementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.model.Bookings;
import com.example.vehiclerentalplatform.model.PaymentRecord;
import com.example.vehiclerentalplatform.model.Roles;
import com.example.vehiclerentalplatform.repository.BookingsRepository;
import com.example.vehiclerentalplatform.security.model.Role;
import com.example.vehiclerentalplatform.security.model.UserEntity;
import com.example.vehiclerentalplatform.security.repository.UserEntityRepository;
import com.example.vehiclerentalplatform.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService{
    @Autowired
    private UserEntityRepository userEntityRepo;

    @Autowired
    private BookingsRepository bookingsRepo;

    @Override
    public List<Bookings> getBookingDetails(String email) {
        Optional<UserEntity> user  = userEntityRepo.findByEmail(email);
        if(user.get().getRole().equals(Role.USER)){
            return bookingsRepo.findByEmail(email);
        }
        return bookingsRepo.findAll();
    }
    
    @Override
    public Bookings createPaymentRecord(Bookings newRecord){
        return bookingsRepo.save(newRecord);
    }
}

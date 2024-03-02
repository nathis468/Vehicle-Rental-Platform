package com.example.vehiclerentalplatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalplatform.model.Bookings;
import com.example.vehiclerentalplatform.model.PaymentRecord;
import com.example.vehiclerentalplatform.service.BookingsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/bookings")
@CrossOrigin()
public class BookingsController {
    @Autowired
    private BookingsService bookingsService;

    @GetMapping("{email}")
    public ResponseEntity<List<Bookings>> getMethodName(@PathVariable String email) {
        return new ResponseEntity<>(bookingsService.getBookingDetails(email),HttpStatus.OK);
    }
    
    @PostMapping("")
    public ResponseEntity<Bookings> postMethodName(@RequestBody Bookings newPayment) {
        return new ResponseEntity<>(bookingsService.createPaymentRecord(newPayment),HttpStatus.OK);
    }
}
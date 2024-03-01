package com.example.vehiclerentalplatform.service;

import java.util.List;

import com.example.vehiclerentalplatform.model.Bookings;

public interface BookingsService {
    List<Bookings> getBookingDetails(String email);
}

package com.example.vehiclerentalplatform.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.vehiclerentalplatform.model.Bookings;
import com.example.vehiclerentalplatform.model.PaymentRecord;

public interface BookingsService {
    Page<Bookings> getBookingDetails(String email, int page, int pageSize);
    Bookings createPaymentRecord(Bookings newRecord);
    void setRatingService(Bookings theBooking,Integer rating);
}

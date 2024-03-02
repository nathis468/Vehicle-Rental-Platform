package com.example.vehiclerentalplatform.service;

import java.util.List;

import com.example.vehiclerentalplatform.model.Bookings;
import com.example.vehiclerentalplatform.model.PaymentRecord;

public interface BookingsService {
    List<Bookings> getBookingDetails(String email);
    Bookings createPaymentRecord(Bookings newRecord);
}

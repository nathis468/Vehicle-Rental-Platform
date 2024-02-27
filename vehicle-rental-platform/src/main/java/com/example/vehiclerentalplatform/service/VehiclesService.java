package com.example.vehiclerentalplatform.service;

import java.util.List;

import com.example.vehiclerentalplatform.model.Vehicles;

public interface VehiclesService {
    List<Vehicles> getAllVehiclesService();
    Vehicles insertNewVehicleService(Vehicles newVehicle);
    double haversine();
}

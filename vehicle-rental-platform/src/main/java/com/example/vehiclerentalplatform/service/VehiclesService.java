package com.example.vehiclerentalplatform.service;

import java.util.List;

import com.example.vehiclerentalplatform.model.Filters;
import com.example.vehiclerentalplatform.model.NearestVehicles;
import com.example.vehiclerentalplatform.model.Vehicles;

public interface VehiclesService {
    List<NearestVehicles> getFilteredVehicleService(Filters newFilter);
    Vehicles insertNewVehicleService(Vehicles newVehicle);
    List<NearestVehicles> haversine(Filters newFilter,List<Vehicles> filteredVehicles);
}

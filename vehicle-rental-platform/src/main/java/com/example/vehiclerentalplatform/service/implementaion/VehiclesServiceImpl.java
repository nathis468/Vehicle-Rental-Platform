package com.example.vehiclerentalplatform.service.implementaion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.model.Vehicles;
import com.example.vehiclerentalplatform.repository.VehiclesRepository;
import com.example.vehiclerentalplatform.service.VehiclesService;

@Service
public class VehiclesServiceImpl implements VehiclesService{

    private static final double EARTH_RADIUS_KM = 6371.0;

    @Autowired
    private VehiclesRepository vehiclesRepo;

    @Override
    public List<Vehicles> getAllVehiclesService() {
        return vehiclesRepo.findAll();
    }

    @Override
    public Vehicles insertNewVehicleService(Vehicles newVehicle) {
        return vehiclesRepo.save(newVehicle);
    }

    @Override
    public double haversine() {

        

        lat1 = Math.toRadians(lat1);
        lon1 = Math.toRadians(lon1);
        lat2 = Math.toRadians(lat2);
        lon2 = Math.toRadians(lon2);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2.0) * Math.sin(dLat / 2.0) +
                   Math.cos(lat1) * Math.cos(lat2) *
                   Math.sin(dLon / 2.0) * Math.sin(dLon / 2.0);

        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));

        double distance = EARTH_RADIUS_KM * c;

        return distance;
    }   

    
}

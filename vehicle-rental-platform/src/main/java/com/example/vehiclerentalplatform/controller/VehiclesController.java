package com.example.vehiclerentalplatform.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclerentalplatform.model.Vehicles;
import com.example.vehiclerentalplatform.service.VehiclesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin()
public class VehiclesController {

    @Autowired
    private VehiclesService vehiclesService;

    @GetMapping("")
    public ResponseEntity<List<Vehicles>> getAllVehiclesController() {
        return new ResponseEntity<>(vehiclesService.getAllVehiclesService(),HttpStatus.OK)  ;
    }

    @PostMapping("")
    public ResponseEntity<Vehicles> insertNewVehicleController(@RequestBody Vehicles newVehicle) {
        return new ResponseEntity<>(vehiclesService.insertNewVehicleService(newVehicle),HttpStatus.OK);
    }

    @GetMapping("/distance")
    public ResponseEntity<?> getDistanceController() {
        return new ResponseEntity<>(vehiclesService.haversine(),HttpStatus.OK);
    }
    
}

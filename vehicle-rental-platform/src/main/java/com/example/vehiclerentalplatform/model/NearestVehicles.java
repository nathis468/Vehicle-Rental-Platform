package com.example.vehiclerentalplatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NearestVehicles {
    private double distance;
    private Vehicles vehicles;
}

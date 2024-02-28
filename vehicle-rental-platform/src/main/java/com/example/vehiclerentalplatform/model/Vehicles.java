package com.example.vehiclerentalplatform.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "vehicles")
public class Vehicles {
    @Id
    private String Id;

    @Field("car_model")
    private String carModel;

    @Field("seating_capacity")
    private String seatingCapacity;

    @Field("mileage")
    private String mileage;
    
    @Field("fuel_capacity")
    private String fuelCapacity;

    @Field("fuel_type")
    private String fuelType;

    @Field("insurance_coverage")
    private String insuranceCoverage;

    @Field("cancellation_policy")
    private String cancellationPolicy;

    @Field("price")
    private String price;

    @Field("latitude")
    private String latitude;

    @Field("longitude")
    private String longitude;

    @Field("ratings")
    private String ratings;

    @Field("booking_details")
    private List<String> booking_details;
}

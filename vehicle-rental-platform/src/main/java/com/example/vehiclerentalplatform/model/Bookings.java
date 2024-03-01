package com.example.vehiclerentalplatform.model;

import java.util.Date;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bookings")
public class Bookings {
    @Id
    private String _id;

    @Field("car_model_name")
    private String carModelName;

    @Field("email")
    private String email;

    @Field("from_date")
    private Date fromDate;

    @Field("to_date")
    private Date toDate;

    @Field("price")
    private String price;

    @Field("status")
    private String status;

    @Field("vehicle_details")
    private String vehcileDetails;
}

package com.example.vehiclerentalplatform.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "maintanance")
public class Maintanance {
    private String carModel;
    private String maintananceType;
    private Date serviceDate;
    private Double price;
    private String description;
    private String image;
    private String status;
}


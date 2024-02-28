package com.example.vehiclerentalplatform.model;

import java.util.Date;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Filters {
    private String latitude;
    private String longitude;
    private Date startDate;
    private Date endDate;
}

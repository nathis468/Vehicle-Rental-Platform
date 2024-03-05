package com.example.vehiclerentalplatform.dto;

import lombok.Data;

@Data
public class Users {
    private String userName;
    private String email;

    public Users(String userName, String email){
        this.userName = userName;
        this.email = email;
    }
}

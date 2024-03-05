package com.example.vehiclerentalplatform.service.implementaion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.model.Maintanance;
import com.example.vehiclerentalplatform.repository.MaintananceRepository;
import com.example.vehiclerentalplatform.service.MaintananceService;

@Service
public class MaintananceServiceImpl implements MaintananceService{

    @Autowired
    private MaintananceRepository maintananceRepo;

    @Override
    public void maintanance (Maintanance details) {
        maintananceRepo.save(details);  

        System.out.println(details);
    }      
}

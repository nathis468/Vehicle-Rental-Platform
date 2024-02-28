package com.example.vehiclerentalplatform.service.implementaion;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalplatform.dto.VehiclesDTO;
import com.example.vehiclerentalplatform.model.Bookings;
import com.example.vehiclerentalplatform.model.Filters;
import com.example.vehiclerentalplatform.model.NearestVehicles;
import com.example.vehiclerentalplatform.model.Vehicles;
import com.example.vehiclerentalplatform.repository.VehiclesRepository;
import com.example.vehiclerentalplatform.service.VehiclesService;

@Service
public class VehiclesServiceImpl implements VehiclesService{

    private static final double EARTH_RADIUS_KM = 6371.0;

    @Autowired
    private VehiclesRepository vehiclesRepo;

    @Autowired
    private VehiclesDTO vehiclesDTO;

    @Override
    public List<NearestVehicles> getFilteredVehicleService(Filters newFilter) {
        List<Bookings> list1;

        try {
            list1 = new ArrayList<>(vehiclesDTO.filteredData1(newFilter.getStartDate(),newFilter.getEndDate()));

            return availableVehicle(newFilter,list1);
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        
        return new ArrayList<NearestVehicles>();
    }

    public List<NearestVehicles> availableVehicle(Filters newFilter,List<Bookings> previouslyBooked){

        List<String> list1 = new ArrayList<>();

        for(int i=0;i<previouslyBooked.size();i++){
            list1.add(previouslyBooked.get(i).getVehcileDetails());
        }

        List<Vehicles> list2 = vehiclesRepo.findAll();
        
        List<Vehicles> filteredList2 = list2.stream().filter(vehicle -> !list1.contains(vehicle.getId())).collect(Collectors.toList());

        System.out.println(filteredList2);

        return haversine(newFilter,filteredList2);
    }


    @Override
    public List<NearestVehicles> haversine(Filters newFilter,List<Vehicles> filteredVehicles) {

        double lat1 = Math.toRadians(Double.parseDouble(newFilter.getLatitude()));
        double lon1 = Math.toRadians(Double.parseDouble(newFilter.getLongitude()));

        List<NearestVehicles> newList = new ArrayList<>();

        for(int i=0;i<filteredVehicles.size();i++){

            double lat2 = Math.toRadians(Double.parseDouble(filteredVehicles.get(i).getLatitude()));
            double lon2 = Math.toRadians(Double.parseDouble(filteredVehicles.get(i).getLatitude()));
            
            double dLat = lat2 - lat1;
            double dLon = lon2 - lon1;
            
            double a = Math.sin(dLat / 2.0) * Math.sin(dLat / 2.0) + Math.cos(lat1) * Math.cos(lat2) * Math.sin(dLon / 2.0) * Math.sin(dLon / 2.0);                 
            double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1.0 - a));
                   
            double distance = EARTH_RADIUS_KM * c;
                   
            NearestVehicles result1 = new NearestVehicles();
            result1.setDistance(distance);
            result1.setVehicles(filteredVehicles.get(i));

            newList.add(result1);

            System.out.println(distance);
        } 
        System.out.println(newList);

        Collections.sort(newList, Comparator.comparing(NearestVehicles::getDistance));

        System.out.println(newList);

        return newList;
        
    }

    @Override
    public Vehicles insertNewVehicleService(Vehicles newVehicle) {
        return vehiclesRepo.save(newVehicle);
    }
}
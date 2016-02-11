package com.brest.practice.service.interfaces;


import com.brest.practice.models.Parking;
import com.brest.practice.models.ParkingDto;

import java.util.List;

public interface ParkingService {

    Integer addParking(Parking parking);

    Integer getCountParkingByName(String parkingName);

    Parking getParkingById(Integer parkingId);

    List<Parking> getAllParkings();

    List<Parking> getAllParkingsPlus();

    void updateParking(Integer parkingId, Parking parking);

    void deleteParking(Integer parkingId);

    ParkingDto getParkingDto();
}
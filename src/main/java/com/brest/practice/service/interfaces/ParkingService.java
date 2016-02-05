package com.brest.practice.service.interfaces;


import com.brest.practice.models.Parking;
import com.brest.practice.models.ParkingDto;

import java.util.List;

public interface ParkingService {

    Integer addParking(Parking parking);

    void updateParking(Integer parkingId, Parking parking);

    Parking getParkingById(Integer parkingId);

    List<Parking> getAllParkings();

    void deleteParking(Integer parkingId);

    void test();

    ParkingDto getParkingDto();
}
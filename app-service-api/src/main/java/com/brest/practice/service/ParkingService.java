package com.brest.practice.service;

import com.brest.practice.core.Parking;

import java.util.List;

/**
 * Created by Shadowofclown on 02.02.2016.
 */
public interface ParkingService {

    List<Parking> getAllParkings();

    Parking getParkingById(Integer parkingId);

    void addParking(Parking parking);

    void updateParking(Integer parkingId, String address);

    void deleteParking(Integer parkingId);
}

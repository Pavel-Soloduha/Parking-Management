package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Parking;

import java.util.List;

public interface ParkingDao {

    Integer addParking(Parking parking);

    Integer getCountParkingByName(String parkingName);

    Parking getParkingById(Integer parkingId);

    List<Parking> getAllParkings();

    List<Parking> getAllParkingsPlus();

    void updateParking(Parking parking);

    void deleteParking(Integer parkingId);
}
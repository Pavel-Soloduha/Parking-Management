package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Parking;

import java.util.List;

public interface ParkingDao {
    Integer addParking(Parking parking);

    void updateParking(Integer parkingId, Parking parking);

    Parking getParkingById(Integer parkingId);

    List<Parking> getAllParkings();

    void deleteParking(Integer parkingId);

    void test();
}
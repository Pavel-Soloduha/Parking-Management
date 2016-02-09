package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Parking;

import java.util.List;

public interface ParkingDao {
    Integer addParking(Parking parking);

    Parking getParkingById(Integer parkingId);

    List<Parking> getAllParkings();

    void updateParking(Integer parkingId, Parking parking);

    void deleteParking(Integer parkingId);

    void test();
}
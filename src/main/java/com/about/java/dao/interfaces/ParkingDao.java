package com.about.java.dao.interfaces;

import com.about.java.models.Parking;

import java.util.List;

public interface ParkingDao {
    Integer addParking(Parking parking);

    void updateParking(Integer parkingId, Parking parking);

    Parking getParkingById(Integer parkingId);

    List<Parking> getParkings();

    void deleteParking(Integer parkingId);
}
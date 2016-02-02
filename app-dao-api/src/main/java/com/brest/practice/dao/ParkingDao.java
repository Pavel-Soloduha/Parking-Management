package com.brest.practice.dao;

import com.brest.practice.core.Parking;
import java.util.List;

/**
 * Created by Shadowofclown on 02.02.2016.
 */
public interface ParkingDao {
    void addParking(Parking parking);

    List<Parking> getAllParkings();

    Parking getParkingById(Integer parkingId);

    void updateParking(String address);

    void deleteParking(Integer parkingId);
}

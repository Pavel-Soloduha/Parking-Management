package com.about.java.service.interfaces;


import com.about.java.models.Parking;
import com.about.java.service.exceptions.NoSuchObjectException;
import com.about.java.service.exceptions.ObjectAlreadyExistsException;

import java.util.List;

public interface ParkingService {

    Integer addParking(Parking parking);

    void updateParking(Integer parkingId, Parking parking);

    Parking getParkingById(Integer parkingId);

    List<Parking> getParkings();

    void deleteParking(Integer parkingId);

}
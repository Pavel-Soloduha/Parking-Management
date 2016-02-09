package com.brest.practice.service.interfaces;

import com.brest.practice.models.Parking;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */
public interface OverseerService {

    List<Parking> getAllParkingsInfo();

    Parking getParkingByIdInfo();
}

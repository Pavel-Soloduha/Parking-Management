package com.brest.practice.service.implement;

import com.brest.practice.models.Parking;
import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.OverseerService;
import com.brest.practice.service.interfaces.ParkingService;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * Created by emergency on 2/9/16.
 */
public class OverseerServiceImpl implements OverseerService {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private TariffService tariffService;

    public List<Parking> getAllParkingsInfo() {
        List<Parking> parkings = parkingService.getAllParkings();
        for (Parking parking : parkings) {
            Integer parkingId = parking.getParkingId();
//            Set<Tariff> tariffs = tariffService.g
        }
        return null;
    }

    public Parking getParkingByIdInfo() {
        return null;
    }
}

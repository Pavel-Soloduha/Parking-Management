package com.brest.practice.rest;

import com.brest.practice.core.Parking;
import com.brest.practice.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Shadowofclown on 02.02.2016.
 */

@RestController
public class ParkingRestController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "parking", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void addParking(@RequestBody Parking parking) {
        parkingService.addParking(parking);
    }

    @RequestMapping(value = "/parkings", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Parking> getAllParkings() {
        return parkingService.getAllParkings();
    }

    @RequestMapping(value = "parking/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Parking getParkingById(@PathVariable(value = "id") Integer parkingId) {
        return parkingService.getParkingById(parkingId);
    }

    @RequestMapping(value = "/parking/{id}/{address}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateParking(@PathVariable(value = "id") Integer parkingId,
                              @PathVariable(value = "address") String address) {
        parkingService.updateParking(parkingId, address);
    }

    @RequestMapping(value = "parking/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteParking(@PathVariable(value = "id") Integer parkingId) {
        parkingService.deleteParking(parkingId);
    }
}

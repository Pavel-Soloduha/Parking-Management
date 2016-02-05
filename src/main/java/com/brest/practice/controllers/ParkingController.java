package com.brest.practice.controllers;

import com.brest.practice.models.Parking;
import com.brest.practice.models.ParkingDto;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    private static String VERSION = "1.0";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Parking> getAllParkings() {
        List<Parking> parkings = parkingService.getAllParkings();
        for(Parking item : parkings) {
            System.out.println(item);
        }
        return parkings;
    }

    @RequestMapping(value = "/parkingdto", method = RequestMethod.GET)
    public @ResponseBody ParkingDto getUserDto() {
        return parkingService.getParkingDto();
    }

    @RequestMapping(value = "parking", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addParking(@RequestBody Parking parking) {
        parkingService.addParking(parking);
    }

    @RequestMapping(value = "/parking/{id}", method = RequestMethod.GET)
    public @ResponseBody Parking getParkingById(@PathVariable(value = "id") Integer parkingId) {
        return parkingService.getParkingById(parkingId);
    }

    @RequestMapping(value = "/parking/{id}", method = RequestMethod.PUT)
    public void updateParking(@PathVariable(value = "id") Integer parkingId,
                              @RequestBody Parking parking) {
        parkingService.updateParking(parkingId, parking);
    }

    @RequestMapping(value = "/parking/{id}", method = RequestMethod.DELETE)
    public void deleteParking(@PathVariable(value = "id") Integer parkingId) {
        parkingService.deleteParking(parkingId);
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String getVersion() {
        return VERSION;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void test() {
        System.out.println("call rest");
        parkingService.test();
    }
}
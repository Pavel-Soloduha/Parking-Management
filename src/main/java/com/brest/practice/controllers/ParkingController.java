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

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String getVersion() {
        System.out.println("i do it");
        return "1.0";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody List<Parking> getAllParkings() {
        List<Parking> parkings = parkingService.getAllParkings();
        for(Parking item : parkings) {
            System.out.println(item);
        }
        return parkings;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void test() {
        System.out.println("call rest");
        parkingService.test();
    }

    @RequestMapping(value = "/parkingdto", method = RequestMethod.GET)
    public @ResponseBody ParkingDto getUserDto() {
        return parkingService.getParkingDto();
    }
}
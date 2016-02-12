package com.brest.practice.controllers;

import com.brest.practice.dto.ParkingDto;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/parking/")
public class ParkingController {

//    parking везде добавить

    @Autowired
    private ParkingService parkingService;

    private static String VERSION = "1.0";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody ParkingDto getAllParkings() {
        return parkingService.getAllParkings();
    }

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public @ResponseBody ParkingDto getAllParkingsPlus() {
        return parkingService.getAllParkingsPlus();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addParking(@RequestBody ParkingDto parkingDto) {
        parkingService.addParking(parkingDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody ParkingDto getParkingById(@PathVariable(value = "id") Integer parkingId) {
        return parkingService.getParkingById(parkingId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateParking(@RequestBody ParkingDto parkingDto) {
        parkingService.updateParking(parkingDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteParking(@PathVariable(value = "id") Integer parkingId) {
        parkingService.deleteParking(parkingId);
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String getVersion() {
        return VERSION;
    }

}
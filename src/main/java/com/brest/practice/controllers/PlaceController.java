package com.brest.practice.controllers;

import com.brest.practice.dto.PlaceDto;
import com.brest.practice.service.interfaces.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by emergency on 2/12/16.
 */

@RestController
@RequestMapping(value = "/place/")
public class PlaceController {

    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addPlace(@RequestBody PlaceDto placeDto) {
        placeService.addPlace(placeDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public PlaceDto getAllPlaces() {
        return placeService.getAllPlaces();
    }

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public PlaceDto getAllPlacesPlus() {
        return placeService.getAllPlacesPlus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PlaceDto getPlaceById(@PathVariable(value = "id") Long placeId) {
        return placeService.getPlaceById(placeId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updatePlace(@RequestBody PlaceDto placeDto) {
        placeService.updatePlace(placeDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlace(@PathVariable(value = "id") Long placeId) {
        placeService.deletePlace(placeId);
    }

}

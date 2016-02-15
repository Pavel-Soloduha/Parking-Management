package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.PlaceDao;
import com.brest.practice.dto.PlaceDto;
import com.brest.practice.models.Place;
import com.brest.practice.service.interfaces.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDao placeDao;

    static void nullificationList(List<Place> places) {
        for(Place place : places) {
            place.setParking(null);
            place.getCarInfo().setPlace(null);
        }

    }

    public Long addPlace(PlaceDto placeDto) {
        Place place = placeDto.getPlaces().get(0);
        if (placeDao.getCountPlace(place.getNumber(), place.getParkingId().getParkingId()) > 0)
            throw new IllegalArgumentException();
        return placeDao.addPlace(place);
    }

    public Integer getCountPlace(Integer number, Integer parkingId) {
        return placeDao.getCountPlace(number, parkingId);
    }

    public PlaceDto getAllPlaces() {
        List<Place> places = placeDao.getAllPlaces();
        nullificationList(places);
        return new PlaceDto(places.size(), places);
    }

    public PlaceDto getAllPlacesPlus() {
        List<Place> places = placeDao.getAllPlacesPlus();
        nullificationList(places);
        return new PlaceDto(places.size(), places);
    }

    public PlaceDto getPlaceById(Long placeId) {
        List<Place> places = new ArrayList<Place>();
        places.add(placeDao.getPlaceById(placeId));
        nullificationList(places);
        return new PlaceDto(1, places);
    }

    public void updatePlace(PlaceDto placeDto) {
        Place place = placeDto.getPlaces().get(0);
        placeDao.updatePlace(place);
    }

    public void deletePlace(Long placeId) {
        placeDao.deletePlace(placeId);
    }
}
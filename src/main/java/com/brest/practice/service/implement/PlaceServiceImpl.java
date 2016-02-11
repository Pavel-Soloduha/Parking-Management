package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.PlaceDao;
import com.brest.practice.models.Place;
import com.brest.practice.service.interfaces.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by emergency on 2/11/16.
 */

@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDao placeDao;

    public Long addPlace(Place place) {
        if (placeDao.getCountPlace(place.getNumber(), place.getParkingId().getParkingId()) > 0)
            throw new IllegalArgumentException();
        return placeDao.addPlace(place);
    }

    public Integer getCountPlace(Integer number, Integer parkingId) {
        return placeDao.getCountPlace(number, parkingId);
    }

    public Place getPlaceById(Long placeId) {
        return placeDao.getPlaceById(placeId);
    }

    public void updatePlace(Long placeId, Place place) {
        placeDao.updatePlace(placeId, place);
    }

    public void deletePlace(Long placeId) {
        placeDao.deletePlace(placeId);
    }
}

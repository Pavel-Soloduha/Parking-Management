package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Place;

import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */
public interface PlaceDao {

    Long addPlace(Place place);

    Integer getCountPlace(Integer number, Integer parkingId);

    Place getPlaceById(Long placeId);

    List<Place> getAllPlaces();

    List<Place> getAllPlacesPlus();

    void updatePlace(Place place);

    void deletePlace(Long placeId);
}

package com.brest.practice.service.interfaces;

import com.brest.practice.models.Place;

/**
 * Created by emergency on 2/11/16.
 */
public interface PlaceService {

    Long addPlace(Place place);

    Integer getCountPlace(Integer number, Integer parkingId);

    Place getPlaceById(Long placeId);

    void updatePlace(Long placeId, Place place);

    void deletePlace(Long placeId);
}

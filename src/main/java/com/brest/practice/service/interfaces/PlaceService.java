package com.brest.practice.service.interfaces;

import com.brest.practice.dto.PlaceDto;

/**
 * Created by emergency on 2/11/16.
 */
public interface PlaceService {

    Long addPlace(PlaceDto placeDto);

    Integer getCountPlace(Integer number, Integer parkingId);

    PlaceDto getAllPlaces();

    PlaceDto getAllPlacesPlus();

    PlaceDto getPlaceById(Long placeId);

    void updatePlace(PlaceDto placeDto);

    void deletePlace(Long placeId);
}

package com.brest.practice.dto;

import com.brest.practice.models.Place;

import java.util.List;

/**
 * Created by emergency on 2/12/16.
 */
public class PlaceDto {

    private Integer total;

    private List<Place> places;

    public PlaceDto() {
    }
    public PlaceDto(Integer total, List<Place> places) {
        this.total = total;
        this.places = places;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Place> getPlaces() {
        return places;
    }
    public void setPlaceList(List<Place> places) {
        this.places = places;
    }
}

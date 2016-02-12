package com.brest.practice.dto;

import com.brest.practice.models.Place;

import java.util.List;

/**
 * Created by emergency on 2/12/16.
 */
public class PlaceDto {

    private Integer total;

    private List<Place> placeList;

    public PlaceDto() {
    }
    public PlaceDto(Integer total, List<Place> placeList) {
        this.total = total;
        this.placeList = placeList;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }
    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }
}

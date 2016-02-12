package com.brest.practice.dto;

import com.brest.practice.models.Parking;

import java.util.List;

/**
 * Created by emergency on 2/5/16.
 */
public class ParkingDto {

    private Integer total;

    private List<Parking> parkings;

    public ParkingDto() {
    }
    public ParkingDto(Integer total, List<Parking> parkings) {
        this.total = total;
        this.parkings = parkings;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Parking> getParkings() {
        return parkings;
    }
    public void setParkings(List<Parking> parkings) {
        this.parkings = parkings;
    }
}

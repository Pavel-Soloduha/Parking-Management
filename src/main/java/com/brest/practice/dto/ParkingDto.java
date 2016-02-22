package com.brest.practice.dto;

import com.brest.practice.models.Parking;

/**
 * Created by emergency on 2/5/16.
 */
public class ParkingDto {

    private Integer parkingId;

    private String parkingName;

    private Integer amountBusy;

    private Integer amountPlace;

    private Integer amountFloor;

    private String address;

    private String description;

    private Boolean isRemoved = false;

    public ParkingDto(Parking parking) {
        this.parkingId = parking.getParkingId();
        this.parkingName = parking.getParkingName();
        this.amountBusy = parking.getAmountBusy();
        this.amountPlace = parking.getAmountPlace();
        this.amountFloor = parking.getAmountFloor();
        this.address = parking.getAddress();
        this.description = parking.getDescription();
        this.isRemoved = parking.getRemoved();
    }

    public Integer getParkingId() {
        return parkingId;
    }
    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }
    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public Integer getAmountBusy() {
        return amountBusy;
    }
    public void setAmountBusy(Integer amountBusy) {
        this.amountBusy = amountBusy;
    }

    public Integer getAmountPlace() {
        return amountPlace;
    }
    public void setAmountPlace(Integer amountPlace) {
        this.amountPlace = amountPlace;
    }

    public Integer getAmountFloor() {
        return amountFloor;
    }
    public void setAmountFloor(Integer amountFloor) {
        this.amountFloor = amountFloor;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }
    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    public Parking createParking() {
        return new Parking(this.parkingId, this.parkingName, this.amountBusy, this.amountPlace
        , this.amountFloor, this.address, this.description, this.isRemoved);
    }
}

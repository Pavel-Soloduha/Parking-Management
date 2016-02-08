package com.brest.practice.models;

import javax.persistence.*;

/**
 * Created by emergency on 2/8/16.
 */

@Entity
@Table(name = "Place")
public class Place {

    @Id
    @Column(name = "placeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer placeId;

    @Column(name = "floor")
    private Integer floor;

    @Column(name = "isCovered")
    private boolean isCovered;

    @Column(name = "isLighted")
    private boolean isLighted;

    //todo add connection
    @Column(name = "parkingId")
    private Integer parkingId;

    public Place() {
    }

    public Place(Integer placeId, Integer floor, boolean isCovered, boolean isLighted, Integer parkingId) {
        this.placeId = placeId;
        this.floor = floor;
        this.isCovered = isCovered;
        this.isLighted = isLighted;
        this.parkingId = parkingId;
    }

    public Integer getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean isCovered() {
        return isCovered;
    }
    public void setCovered(boolean covered) {
        isCovered = covered;
    }

    public boolean isLighted() {
        return isLighted;
    }
    public void setLighted(boolean lighted) {
        isLighted = lighted;
    }

    public Integer getParkingId() {
        return parkingId;
    }
    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", floor=" + floor +
                ", isCovered=" + isCovered +
                ", isLighted=" + isLighted +
                ", parkingId=" + parkingId +
                '}';
    }
}

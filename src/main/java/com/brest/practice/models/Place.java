package com.brest.practice.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by emergency on 2/8/16.
 */

@Entity
@Table(name = "Place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "placeId")
    private Integer placeId;

    @NotNull
    @Min(value = 1)
    @Column(name = "floor")
    private Integer floor;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parkingId")
    private Parking parking;

    public Place() {
    }
    public Place(Integer floor, Parking parking) {
        this.floor = floor;
        this.parking = parking;
    }
    public Place(Integer placeId, Integer floor, Parking parking) {
        this.placeId = placeId;
        this.floor = floor;
        this.parking = parking;
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

    public Parking getParkingId() {
        return parking;
    }
    public void setParkingId(Parking parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                ", floor=" + floor +
                ", Parking=" + parking +
                '}';
    }
}

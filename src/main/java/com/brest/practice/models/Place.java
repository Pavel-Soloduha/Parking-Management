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

    //todo add connection
//    @ManyToOne
//    @JoinColumn(name="parkingId")
    @ManyToOne
    @JoinColumn(name="department_id",
            insertable=false, updatable=false,
            nullable=false)
    private Integer parkingId;

    public Place() {
    }
    public Place(Integer placeId, Integer floor, Integer parkingId) {
        this.placeId = placeId;
        this.floor = floor;
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
                ", parkingId=" + parkingId +
                '}';
    }
}

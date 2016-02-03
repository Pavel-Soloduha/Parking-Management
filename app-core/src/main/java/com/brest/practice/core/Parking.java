package com.brest.practice.core;

import javax.persistence.*;

/**
 * Created by Shadowofclown on 02.02.2016.
 */

@Entity
@Table(name = "parking")
public class Parking {

    @Id
    @Column(name = "parkingId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer parkingId;
    @Column(name = "amountPlace")
    private Integer amountPlace;
    @Column(name = "address")
    private String address;

    public Parking() {

    }

    public Parking(Integer parkingId, Integer amountPlace, String address) {
        this.parkingId = parkingId;
        this.amountPlace = amountPlace;
        this.address = address;
    }

    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getAmountPlace() {
        return amountPlace;
    }

    public void setAmountPlace(Integer amountPlace) {
        this.amountPlace = amountPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

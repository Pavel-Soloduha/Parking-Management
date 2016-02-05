package com.brest.practice.models;

import javax.persistence.*;

@Entity
@Table(name = "parking")
public class Parking {


    @Id
    @Column(name = "parkingId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "amountPlace")
    private Integer amountPlace;

    @Column(name = "address")
    private String address;

    public Parking() {

    }

    public Parking(Integer id, Integer amountPlace, String address) {
        this.id = id;
        this.amountPlace = amountPlace;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

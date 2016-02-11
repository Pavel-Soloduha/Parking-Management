package com.brest.practice.models;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

/**
 * Created by emergency on 2/8/16.
 */

@Entity
@Table(name = "Place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "placeId")
    private Long placeId;

    @NotNull
    @Min(value = 0)
    @Column(name = "number")
    private Integer number;

    @NotNull
    @Min(value = 0)
    @Column(name = "floor")
    private Integer floor;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "parkingId")
    private Parking parking;

    @NotNull
    @Size(min = 4, max = 15)
    @Column(name = "carAuth")
    private String carAuth;

    @NotNull
    @Future
    @Column(name = "startDate")
    private Date startDate;

    @Future
    @Column(name = "endDate")
    private Date endDate;

    @NotNull
    @Min(value = 0)
    @Column(name = "price")
    private Double price;

    @NotNull
    @Min(value = 0)
    @Column(name = "tariffId")
    private Integer tariffId;

    @NotNull
    @Column(name = "removed")
    private Boolean isRemoved = false;

    public Place() {
    }
    public Place(Integer number, Integer floor, Parking parking, Double price) {
        this.number = number;
        this.floor = floor;
        this.parking = parking;
        this.price = price;
    }
    public Place(Integer number, Integer floor, Parking parking, String carAuth, Date startDate, Date endDate, Double price, Integer tariffId, Long placeId) {
        this.number = number;
        this.floor = floor;
        this.parking = parking;
        this.carAuth = carAuth;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.tariffId = tariffId;
        this.placeId = placeId;
    }

    public Long getPlaceId() {
        return placeId;
    }
    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
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

    public Parking getParking() {
        return parking;
    }
    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public String getCarAuth() {
        return carAuth;
    }
    public void setCarAuth(String carAuth) {
        this.carAuth = carAuth;
    }

    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTariffId() {
        return tariffId;
    }
    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }
    public void setRemoved(Boolean removed) {
        isRemoved = removed;
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeId=" + placeId +
                "number=" + number +
                ", floor=" + floor +
                ", parking=" + parking +
                ", carAuth='" + carAuth + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", tariffId=" + tariffId +
                '}';
    }

    public void copy(Place place) {
        this.number = place.number;
        this.floor = place.floor;
        this.parking = place.parking;
        this.carAuth = place.carAuth;
        this.startDate = place.startDate;
        this.endDate = place.endDate;
        this.price = place.price;
        this.tariffId = place.tariffId;
        this.isRemoved = place.isRemoved;
    }
}
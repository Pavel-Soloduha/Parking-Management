package com.brest.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Parking")
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "parkingId")
    private Integer parkingId;

    @NotNull
    @Min(value = 0)
    @Column(name = "busyPlace")
    private Integer busyPlace;

    @NotNull
    @Min(value = 1)
    @Column(name = "amountPlace")
    private Integer amountPlace;

    @NotNull
    @Min(value = 1)
    @Column(name = "amountFloor")
    private Integer amountFloor;

    @NotNull
    @Size(min = 10, max = 45)
    @Column(name = "address")
    private String address;

    //// FIXME: 2/9/16 
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Parking_Tariff",
        joinColumns = { @JoinColumn(name = "parkingId") },
        inverseJoinColumns = { @JoinColumn(name  = "tariffId") })
    Set<Tariff> tariffs = new HashSet<Tariff>();

    //// FIXME: 2/9/16
    @JsonIgnore
    @OneToMany(mappedBy = "parking")
    Set<Place> places = new HashSet<Place>();

    public Parking() {

    }
    public Parking(Integer amountPlace, Integer amountFloor, String address) {
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
    }
    public Parking(Integer parkingId, Integer amountPlace, Integer amountFloor, String address) {
        this.parkingId = parkingId;
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
    }
    public Parking(Integer parkingId, Integer amountPlace, Integer amountFloor, String address, Set<Tariff> tariffs) {
        this.parkingId = parkingId;
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
        this.tariffs = tariffs;
    }

    public Integer getParkingId() {
        return parkingId;
    }
    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public Integer getBusyPlace() {
        return busyPlace;
    }
    public void setBusyPlace(Integer busyPlace) {
        this.busyPlace = busyPlace;
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

    public Set<Tariff> getTariffs() {
        return tariffs;
    }
    public void setTariffs(Set<Tariff> tariffs) {
        this.tariffs = tariffs;
    }
    public void addTariff(Tariff tariff) {
        tariffs.add(tariff);
    }
    public void deleteTariff(Tariff tariff) {
        tariffs.remove(tariff);
    }

    public Set<Place> getPlaces() {
        return places;
    }
    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
    public void addPlace(Place place) {
        places.add(place);
    }
    public void deletePlace(Place place) {
        places.remove(place);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingId +
                ", amountPlace=" + amountPlace +
                ", address='" + address + '\'' +
                ", tariffs=" + tariffs.toString() +
                '}';
    }

    public void copy(Parking parking) {
        this.amountPlace = parking.amountPlace;
        this.address = parking.address;
        this.tariffs = parking.tariffs;
    }
}
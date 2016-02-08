package com.brest.practice.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Parking")
public class Parking {

    @Id
    @Column(name = "parkingId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer parkingId;

    @Column(name = "amountPlace")
    private Integer amountPlace;

    @Column(name = "amountFloor")
    private Integer amountFloor;

    @Column(name = "address")
    private String address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Parking_Tariff",
        joinColumns = { @JoinColumn(name = "parkingId") },
        inverseJoinColumns = { @JoinColumn(name  = "tariffId") })
    Set<Tariff> tariffs = new HashSet<Tariff>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Parking_Place",
        joinColumns = { @JoinColumn(name = "parkingId") },
        inverseJoinColumns = { @JoinColumn(name = "placeId") })
    Set<Place> places = new HashSet<Place>();

    public Parking() {

    }

    public Parking(Integer parkingId, Integer amountPlace, Integer amountFloor, String address) {
        this.parkingId = parkingId;
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
    }

    public Parking(Integer parkingId, Integer amountPlace, Integer amountFloor, String address, Set<Tariff> tariffs, Set<Place> places) {
        this.parkingId = parkingId;
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
        this.tariffs = tariffs;
        this.places = places;
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
                ", places=" + places.toString() +
                '}';
    }

    public void copy(Parking parking) {
        this.amountPlace = parking.amountPlace;
        this.address = parking.address;
        this.tariffs = parking.tariffs;
        this.places = parking.places;
    }
}
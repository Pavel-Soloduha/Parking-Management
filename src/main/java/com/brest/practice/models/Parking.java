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
    @Size(min = 5, max = 20)
    @Column(name = "parkingName")
    private String parkingName;

    @NotNull
    @Min(value = 0)
    @Column(name = "amountBusy")
    private Integer amountBusy;

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

    @NotNull
    @Size(min = 10, max = 50)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "removed")
    private Boolean isRemoved = false;

    //todo
//    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //fetch.type = lazy
    @JoinTable(name = "Parking_Tariff",
        joinColumns = { @JoinColumn(name = "parkingId") },
        inverseJoinColumns = { @JoinColumn(name  = "tariffId") })
    private Set<Tariff> tariffs = new HashSet<Tariff>();

    //todo
//    @JsonIgnore
    @OneToMany(mappedBy = "parking", fetch = FetchType.LAZY)
    private Set<Place> places = new HashSet<Place>();

    public Parking() {
    }
    public Parking(String parkingName, Integer amountBusy, Integer amountPlace, Integer amountFloor, String address, String description) {
        this.parkingName = parkingName;
        this.amountBusy = amountBusy;
        this.amountPlace = amountPlace;
        this.amountFloor = amountFloor;
        this.address = address;
        this.description = description;
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
                ", parkingName='" + parkingName + '\'' +
                ", amountBusy=" + amountBusy +
                ", amountPlace=" + amountPlace +
                ", amountFloor=" + amountFloor +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", isRemoved=" + isRemoved +
                ", tariffs=" + tariffs +
                ", places=" + places +
                '}';
    }

    public void copy(Parking parking) {
        this.parkingName = parking.parkingName;
        this.amountBusy = parking.amountBusy;
        this.amountPlace = parking.amountPlace;
        this.amountFloor = parking.amountFloor;
        this.address = parking.address;
        this.description = parking.description;
        this.tariffs = parking.tariffs;
        this.places = parking.places;
    }
}
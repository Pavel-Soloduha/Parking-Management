package com.brest.practice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by emergency on 2/8/16.
 */

@Entity
@Table(name = "Tariff")
public class Tariff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariffId")
    private Integer tariffId;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(name = "tariffName")
    private String tariffName;

    @NotNull
    @Min(value = 0)
    @Column(name = "costPerHour")
    private Double costPerHour;

    @NotNull
    @Size(min = 20, max = 150)
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "removed")
    private Boolean isRemoved = false;

    //todo
    @JsonIgnore
    @ManyToMany(mappedBy = "tariffs")
    private Set<Parking> parkings = new HashSet<Parking>();

    public Tariff() {
    }
    public Tariff(String tariffName, Double costPerHour, String description) {
        this.tariffName = tariffName;
        this.costPerHour = costPerHour;
        this.description = description;
    }

    public Integer getTariffId() {
        return tariffId;
    }
    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public String getTariffName() {
        return tariffName;
    }
    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }
    public void setCostPerHour(Double costPerHour) {
        this.costPerHour = costPerHour;
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

    public Set<Parking> getParkings() {
        return parkings;
    }
    public void setParkings(Set<Parking> parkings) {
        this.parkings = parkings;
    }
    public void addParking(Parking parking) {
        parkings.add(parking);
    }
    public void deleteParking(Parking parking) {
        parkings.remove(parking);
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffId=" + tariffId +
                ", tariffName='" + tariffName + '\'' +
                ", costPerHour=" + costPerHour +
                ", description='" + description + '\'' +
                ", isRemoved=" + isRemoved +
                ", parkings=" + parkings +
                '}';
    }
}
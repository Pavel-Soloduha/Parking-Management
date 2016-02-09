package com.brest.practice.models;

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
    @Min(value = 0)
    @Column(name = "costPerHour")
    private Double costPerHour;

    @NotNull
    @Size(min = 10, max = 255)
    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "tariffs")
    private Set<Parking> parkings = new HashSet<Parking>();

    public Tariff() {
    }
    public Tariff(Double costPerHour, String description) {
        this.description = description;
        this.costPerHour = costPerHour;
    }
    public Tariff(Integer tariffId, Double costPerHour, String description) {
        this.tariffId = tariffId;
        this.costPerHour = costPerHour;
        this.description = description;
    }

    public Integer getTariffId() {
        return tariffId;
    }
    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
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

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffId=" + tariffId +
                ", costPerHour=" + costPerHour +
                ", description='" + description + '\'' +
                ", parkings=" + parkings +
                '}';
    }

    public void copy(Tariff tariff) {
        this.costPerHour = tariff.costPerHour;
        this.description = tariff.description;
    }
}

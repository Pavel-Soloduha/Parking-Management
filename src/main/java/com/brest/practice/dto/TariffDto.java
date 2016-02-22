package com.brest.practice.dto;

import com.brest.practice.models.Tariff;

/**
 * Created by emergency on 2/12/16.
 */
public class TariffDto {

    private Integer tariffId;

    private String tariffName;

    private Double costPerHour;

    private String description;

    private Boolean isRemoved = false;

    public TariffDto(Tariff tariff) {
        this.tariffId = tariff.getTariffId();
        this.tariffName = tariff.getTariffName();
        this.costPerHour = tariff.getCostPerHour();
        this.description = tariff.getDescription();
        this.isRemoved = tariff.getRemoved();
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

    public Tariff createTariff() {
        return new Tariff(tariffId, tariffName, costPerHour, description, isRemoved);
    }
}

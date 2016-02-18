package com.brest.practice.dto;

import com.brest.practice.models.Tariff;

import java.util.Collection;
import java.util.List;

/**
 * Created by emergency on 2/12/16.
 */
public class TariffDto {

    private Integer total;

    private List<Tariff> tariffs;


    public TariffDto() {
    }
    public TariffDto(Integer total, List<Tariff> tariffs) {
        this.total = total;
//        this.tariffs = new Collection<>();
        this.tariffs = tariffs;
    }

    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }
    public void setTariffs(List<Tariff> tariffs) {
        this.tariffs = tariffs;
    }
}

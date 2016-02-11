package com.brest.practice.service.interfaces;

import com.brest.practice.models.Tariff;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */
public interface TariffService {

    Integer addTariff(Tariff tariff);

    Integer getCountTariffByName(String tariffName);

    Tariff getTariffById(Integer tariffId);

    List<Tariff> getAllTariffs();

    List<Tariff> getAllTariffPlus();

    void updateTariff(Integer tariffId, Tariff tariff);

    void deleteTariff(Integer tariffId);
}

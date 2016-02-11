package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Tariff;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */
public interface TariffDao {

    Integer addTariff(Tariff tariff);

    Integer getCountTariffByName(String tariffName);

    Tariff getTariffById(Integer tariffId);

    List<Tariff> getAllTariffs();

    List<Tariff> getAllTariffsPlus();

    void updateTariff(Integer tariffId, Tariff tariff);

    void deleteTariff(Integer tariffId);
}
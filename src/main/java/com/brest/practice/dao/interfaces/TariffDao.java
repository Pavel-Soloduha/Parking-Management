package com.brest.practice.dao.interfaces;

import com.brest.practice.models.Tariff;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */
public interface TariffDao {

    void addTariff(Tariff tariff);

    List<Tariff> getAllTariffs();

    Tariff getTariffById(Integer tariffId);

    void updateTariff(Integer tariffId, Tariff tariff);

    void deleteTariff(Integer tariffId);

    Integer getCountByName(String tariffName);
}

package com.brest.practice.service.interfaces;

import com.brest.practice.dto.TariffDto;
import com.brest.practice.models.Tariff;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */
public interface TariffService {

    Integer addTariff(TariffDto tariffDto);

    Integer getCountTariffByName(String tariffName);

    TariffDto getTariffById(Integer tariffId);

    List<TariffDto> getAllTariffs();

    List<TariffDto> getAllTariffPlus();

    void updateTariff(TariffDto tariffDto);

    void deleteTariff(Integer tariffId);

    List<TariffDto> getTariffsByParkingId(Integer parkingId);
}

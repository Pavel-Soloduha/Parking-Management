package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.dto.TariffDto;
import com.brest.practice.models.Parking;
import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */

@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffDao tariffDao;

    static void nullificationList(List<Tariff> tariffs) {
        for(Tariff tariff : tariffs) {
            for (Parking parking : tariff.getParkings()) {
                parking.setTariffs(null);
                parking.setPlaces(null);
            }
        }
    }

    public Integer addTariff(TariffDto tariffDto) {
        Tariff tariff = tariffDto.getTariffs().get(0);
        if (tariffDao.getCountTariffByName(tariff.getTariffName()) > 0)
            //todo add exception
            throw new IllegalArgumentException();

        return tariffDao.addTariff(tariff);
    }

    public Integer getCountTariffByName(String tariffName) {
        return tariffDao.getCountTariffByName(tariffName);
    }

    public TariffDto getTariffById(Integer tariffId) {
        List<Tariff> tariffs = new ArrayList<Tariff>();
        tariffs.add(tariffDao.getTariffById(tariffId));
        nullificationList(tariffs);
        TariffDto tariffDto = new TariffDto(tariffs.size(), tariffs);
        return tariffDto;
    }

    public TariffDto getAllTariffs() {
        List<Tariff> tariffs = tariffDao.getAllTariffs();
        nullificationList(tariffs);
        return new TariffDto(tariffs.size(), tariffs);
    }

    public TariffDto getAllTariffPlus() {
        List<Tariff> tariffs = tariffDao.getAllTariffsPlus();
        nullificationList(tariffs);
        return new TariffDto(tariffs.size(), tariffs);
    }

    public void updateTariff(TariffDto tariffDto) {
        tariffDao.updateTariff(tariffDto.getTariffs().get(0));
    }

    public void deleteTariff(Integer tariffId) {
        tariffDao.deleteTariff(tariffId);
    }
}

package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */

@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffDao tariffDao;

    public Integer addTariff(Tariff tariff) {
        if (tariffDao.getCountTariffByName(tariff.getTariffName()) > 0)
            //add exception
            throw new IllegalArgumentException();

        return tariffDao.addTariff(tariff);
    }

    public Integer getCountTariffByName(String tariffName) {
        return tariffDao.getCountTariffByName(tariffName);
    }

    public Tariff getTariffById(Integer tariffId) {
        return tariffDao.getTariffById(tariffId);
    }

    public List<Tariff> getAllTariffs() {
        return tariffDao.getAllTariffs();
    }

    public List<Tariff> getAllTariffPlus() {
        return tariffDao.getAllTariffsPlus();
    }

    public void updateTariff(Integer tariffId, Tariff tariff) {
        tariffDao.updateTariff(tariffId, tariff);
    }

    public void deleteTariff(Integer tariffId) {
        tariffDao.deleteTariff(tariffId);
    }
}

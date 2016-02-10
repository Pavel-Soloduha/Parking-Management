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

    public void addTariff(Tariff tariff) {
        tariffDao.getCountByName(tariff.getTariffName());
    }

    public List<Tariff> getAllTariffs() {
        return null;
    }

    public Tariff getTariffById(Integer tariffId) {
        return null;
    }

    public void updateTariff(Integer tariffId, Tariff tariff) {

    }

    public void deleteTariff(Integer tariffId) {

    }
}

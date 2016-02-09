package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.models.Tariff;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */

@Component
public class TariffDaoImpl implements TariffDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addTariff(Tariff tariff) {

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

package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.models.Tariff;
import org.hibernate.Query;
import org.hibernate.Session;
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

    public Integer getCountByName(String tariffName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Tariff where tariffName = :name AND removed = 0");
        query.setParameter("name", tariffName);
        List <Tariff> tariffs = query.list();
        return tariffs.size();
    }
}

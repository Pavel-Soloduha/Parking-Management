package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.models.Tariff;
import org.hibernate.Query;
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

    public Integer addTariff(Tariff tariff) {
        sessionFactory.getCurrentSession().save(tariff);
        return tariff.getTariffId();
    }

    public Integer getCountTariffByName(String tariffName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Tariff where tariffName = :name AND removed = 0");
        query.setParameter("name", tariffName);
        return (Integer) query.list().get(0);
    }

    public Tariff getTariffById(Integer tariffId) {
        return (Tariff) sessionFactory.getCurrentSession().get(Tariff.class, tariffId);
    }

    public List<Tariff> getAllTariffs() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Tariff where removed = 0");
        return query.list();
    }

    public List<Tariff> getAllTariffsPlus() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Tariff");
        return query.list();
    }

    public void updateTariff(Tariff tariff) {
        Tariff oldTariff = (Tariff) sessionFactory.getCurrentSession().get(Tariff.class, tariff.getTariffId());
        oldTariff.copy(tariff);
        sessionFactory.getCurrentSession().update(oldTariff);

    }

    public void deleteTariff(Integer tariffId) {
        Tariff tariff = (Tariff) sessionFactory.getCurrentSession().get(Tariff.class, tariffId);
        tariff.setRemoved(true);
        sessionFactory.getCurrentSession().update(tariff);
    }

    public List<Tariff> getTariffsByParkingId(Integer parkingId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("Select a from Tariff a join a.parkings b where b.parkingId=:id and a.isRemoved=0")
                .setParameter("id", parkingId);
        return query.list();
    }
}
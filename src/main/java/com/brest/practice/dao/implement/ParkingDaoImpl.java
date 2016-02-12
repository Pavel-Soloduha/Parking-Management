package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ParkingDaoImpl implements ParkingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer addParking(Parking parking) {
        sessionFactory.getCurrentSession().save(parking);
        return parking.getParkingId();
    }

    public Integer getCountParkingByName(String parkingName) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Parking where parkingName = :name AND removed = 0");
        query.setParameter("name", parkingName);
        return (Integer) query.list().get(0);
    }

    public Parking getParkingById(Integer parkingId) {
        return (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);
    }

    public List<Parking> getAllParkings() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Parking where removed = 0");
        return query.list();
    }

    public List<Parking> getAllParkingsPlus() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from Parking");
        return query.list();
    }

    public void updateParking(Parking parking) {
        Parking oldParking = (Parking) sessionFactory.getCurrentSession().get(Parking.class, parking.getParkingId());
        oldParking.copy(parking);
        sessionFactory.getCurrentSession().update(oldParking);
    }

    public void deleteParking(Integer parkingId) {
        Parking parking = (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);
        parking.setRemoved(true);
        sessionFactory.getCurrentSession().update(parking);
    }
}

package com.brest.practice.dao;

import com.brest.practice.core.Parking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Shadowofclown on 02.02.2016.
 */

public class ParkingDaoImpl implements ParkingDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addParking(Parking parking) {
           sessionFactory.getCurrentSession().save(parking);
    }

    @Override
    public List<Parking> getAllParkings() {
        return null;
    }

    @Override
    public Parking getParkingById(Integer parkingId) {
        return (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);
    }

    @Override
    public void updateParking(Integer parkingId, String address) {
        sessionFactory.getCurrentSession().update(Parking.class);
    }

    @Override
    public void deleteParking(Integer parkingId) {
        Parking parking = (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);

        if (parking != null){
            sessionFactory.getCurrentSession().delete(parking);
        }
    }
}

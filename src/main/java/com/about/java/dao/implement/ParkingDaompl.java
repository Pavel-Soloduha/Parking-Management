package com.about.java.dao.implement;

import com.about.java.dao.interfaces.ParkingDao;
import com.about.java.models.Parking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingDaompl implements ParkingDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Integer addParking(Parking parking) {
        sessionFactory.getCurrentSession().save(parking);
        return parking.getId();
    }

    public void updateParking(Integer parkingId, Parking parking) {
        //todo
    }

    public Parking getParkingById(Integer parkingId) {
        return (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);
    }

    public List<Parking> getParkings() {
        try{
            Criteria criteria = sessionFactory.
                    getCurrentSession().
                    createCriteria(Parking.class);
            return criteria.list();
        } catch (HibernateException e){
            e.printStackTrace();
        }

        return null;
    }

    public void deleteParking(Integer parkingId) {
        Parking parking = (Parking) sessionFactory.getCurrentSession().get(Parking.class, parkingId);

        if (parking != null){
            sessionFactory.getCurrentSession().delete(parking);
        }
    }
}

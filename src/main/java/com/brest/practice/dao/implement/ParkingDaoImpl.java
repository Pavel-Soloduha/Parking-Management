package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParkingDaoImpl implements ParkingDao {

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

    public List<Parking> getAllParkings() {
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

    public void test() {
        System.out.println("call dao");
    }
}

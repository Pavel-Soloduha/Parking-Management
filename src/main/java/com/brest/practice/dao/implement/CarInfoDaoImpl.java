package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.CarInfoDao;
import com.brest.practice.models.CarInfo;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */

@Component
public class CarInfoDaoImpl implements CarInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public CarInfo getCarInfoById(Long carInfoId) {
        return (CarInfo) sessionFactory.getCurrentSession().get(CarInfo.class, carInfoId);
    }

    public List<CarInfo> getAllCarInfo() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CarInfo where removed = 0");
        return query.list();
    }

    public List<CarInfo> getAllCarInfoPlus() {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from CarInfo");
        return query.list();
    }
}

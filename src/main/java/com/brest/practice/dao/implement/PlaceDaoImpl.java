package com.brest.practice.dao.implement;

import com.brest.practice.dao.interfaces.PlaceDao;
import com.brest.practice.models.Place;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by emergency on 2/11/16.
 */
public class PlaceDaoImpl implements PlaceDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Long addPlace(Place place) {
        sessionFactory.getCurrentSession().save(place);
        return place.getPlaceId();
    }

    public Integer getCountPlace(Integer number, Integer parkingId) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(*) from Tariff where number = :num AND parkingId = :parkId AND removed = 0");
        query.setParameter("num", number);
        query.setParameter("parkId", parkingId);
        return (Integer) query.list().get(0);
    }

    public Place getPlaceById(Long placeId) {
        return (Place) sessionFactory.getCurrentSession().get(Place.class, placeId);
    }

    public void updatePlace(Long placeId, Place place) {
        Place oldPlace = (Place) sessionFactory.getCurrentSession().get(Place.class, placeId);
        oldPlace.copy(place);
        sessionFactory.getCurrentSession().update(oldPlace);
    }

    public void deletePlace(Long placeId) {
        Place place = (Place) sessionFactory.getCurrentSession().get(Place.class, placeId);
        place.setRemoved(true);
        sessionFactory.getCurrentSession().update(place);
    }
}

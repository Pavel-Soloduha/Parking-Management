package com.brest.practice.testApp;

import com.brest.practice.models.Parking;
import com.brest.practice.models.Place;
import com.brest.practice.models.Tariff;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by emergency on 2/8/16.
 */
public class testApp {

    @Autowired
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Parking park1 = new Parking(1, 2, 1, "first");
        Parking park2 = new Parking(2, 4, 1, "second");

        Tariff tar1 = new Tariff(1, 40.0, "tar1");
        Tariff tar2 = new Tariff(2, 30.0, "tar2");
        Tariff tar3 = new Tariff(3, 20.0, "tar3");

        Place pl1 = new Place(1, 1, 1);
        Place pl2 = new Place(2, 1, 1);
        Place pl3 = new Place(3, 1, 2);

        park1.addTariff(tar1);
        park1.addTariff(tar3);
        park2.addTariff(tar2);
        park2.addTariff(tar3);

        park1.addPlace(pl1);
        park1.addPlace(pl2);
        park2.addPlace(pl3);

        session.save(park1);
        session.save(park2);

        session.getTransaction().commit();
        session.close();



    }
}

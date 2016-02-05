package com.about.java.service.implement;


import com.about.java.dao.interfaces.ParkingDao;
import com.about.java.models.Parking;
import com.about.java.service.exceptions.NoSuchObjectException;
import com.about.java.service.exceptions.ObjectAlreadyExistsException;
import com.about.java.service.interfaces.ParkingService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;

    public Integer addParking(Parking parking) {
        return parkingDao.addParking(parking);
    }

    public void updateParking(Integer parkingId, Parking parking) {
        parkingDao.updateParking(parkingId, parking);
    }

    public Parking getParkingById(Integer parkingId) {
        return parkingDao.getParkingById(parkingId);
    }

    public List<Parking> getParkings() {
        return parkingDao.getParkings();
    }

    public void deleteParking(Integer parkingId) {
        parkingDao.deleteParking(parkingId);
    }
}

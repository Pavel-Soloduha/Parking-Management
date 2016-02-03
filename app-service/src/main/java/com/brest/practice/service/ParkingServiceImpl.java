package com.brest.practice.service;

import com.brest.practice.core.Parking;
import com.brest.practice.dao.ParkingDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by emergency on 2/3/16.
 */
@Transactional
public class ParkingServiceImpl implements ParkingService {

    private ParkingDao parkingDao;

    public void setParkingDao(ParkingDao parkingDao) {
        this.parkingDao = parkingDao;
    }

    @Override
    public List<Parking> getAllParkings() {
        return parkingDao.getAllParkings();
    }

    @Override
    public Parking getParkingById(Integer parkingId) {
        return parkingDao.getParkingById(parkingId);
    }

    @Override
    public void addParking(Parking parking) {
        parkingDao.addParking(parking);
    }

    @Override
    public void updateParking(Integer parkingId, String address) {
        parkingDao.updateParking(parkingId, address);
    }

    @Override
    public void deleteParking(Integer parkingId) {
        parkingDao.deleteParking(parkingId);
    }
}

package com.brest.practice.service.implement;


import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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

    public void test() {
        System.out.println("call service");
        parkingDao.test();
    }
}

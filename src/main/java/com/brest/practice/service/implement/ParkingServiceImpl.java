package com.brest.practice.service.implement;


import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import com.brest.practice.models.ParkingDto;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;

    public Integer addParking(Parking parking) {
        if (parkingDao.getCountParkingByName(parking.getParkingName()) > 0)
            throw new IllegalArgumentException();

        return parkingDao.addParking(parking);
    }

    public Integer getCountParkingByName(String parkingName) {
        return parkingDao.getCountParkingByName(parkingName);
    }

    public Parking getParkingById(Integer parkingId) {
        return parkingDao.getParkingById(parkingId);
    }

    public List<Parking> getAllParkings() {
        return parkingDao.getAllParkings();
    }

    public List<Parking> getAllParkingsPlus() {
        return parkingDao.getAllParkingsPlus();
    }

    public void updateParking(Integer parkingId, Parking parking) {
        parkingDao.updateParking(parkingId, parking);
    }

    public void deleteParking(Integer parkingId) {
        parkingDao.deleteParking(parkingId);
    }

    public ParkingDto getParkingDto() {
        ParkingDto parkingDto = new ParkingDto();
        parkingDto.setTotal(parkingDao.getAllParkings().size());
        if (parkingDto.getTotal() > 0) {
            parkingDto.setParkings(parkingDao.getAllParkings());
        } else {
            parkingDto.setParkings(Collections.<Parking>emptyList());
        }
        return parkingDto;
    }
}

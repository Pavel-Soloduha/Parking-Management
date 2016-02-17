package com.brest.practice.service.implement;


import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import com.brest.practice.dto.ParkingDto;
import com.brest.practice.models.Place;
import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;

    static void nullification(List<Parking> parkings) {
        for(Parking parking : parkings) {
            for(Tariff tar : parking.getTariffs()) {
                tar.setParkings(null);
            }
            for(Place place : parking.getPlaces()) {
                place.getCarInfo().setPlace(null);
                place.setParking(null);
            }
        }
    }

    public Integer addParking(ParkingDto parkingDto) {
        Parking parking = parkingDto.getParkings().get(0);
        if (parkingDao.getCountParkingByName(parking.getParkingName()) > 0)
            throw new IllegalArgumentException();

        return parkingDao.addParking(parking);
    }

    public Integer getCountParkingByName(String parkingName) {
        return parkingDao.getCountParkingByName(parkingName);
    }

    public ParkingDto getParkingById(Integer parkingId) {
        List<Parking> parkings = new ArrayList<Parking>();
        parkings.add(parkingDao.getParkingById(parkingId));
        nullification(parkings);
        ParkingDto parkingDto = new ParkingDto(1, parkings);
        return parkingDto;
    }

    public ParkingDto getAllParkings() {
        List<Parking> parkings = parkingDao.getAllParkings();
        nullification(parkings);
        return new ParkingDto(parkings.size(), parkings);
    }

    public ParkingDto getAllParkingsPlus() {
        List<Parking> parkings = parkingDao.getAllParkingsPlus();
        nullification(parkings);
        return new ParkingDto(parkings.size(), parkings);
    }

    public void updateParking(ParkingDto parkingDto) {
        parkingDao.updateParking(parkingDto.getParkings().get(0));
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

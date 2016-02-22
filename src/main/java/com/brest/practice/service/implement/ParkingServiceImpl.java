package com.brest.practice.service.implement;


import com.brest.practice.dao.interfaces.ParkingDao;
import com.brest.practice.models.Parking;
import com.brest.practice.dto.ParkingDto;
import com.brest.practice.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkingDao parkingDao;

    public Integer addParking(ParkingDto parkingDto) {
        Parking parking = parkingDto.createParking();
        if (parkingDao.getCountParkingByName(parking.getParkingName()) > 0)
            throw new IllegalArgumentException();

        return parkingDao.addParking(parking);
    }

    public Integer getCountParkingByName(String parkingName) {
        return parkingDao.getCountParkingByName(parkingName);
    }

    public ParkingDto getParkingById(Integer parkingId) {
        ParkingDto parkingDto = new ParkingDto(parkingDao.getParkingById(parkingId));
        return parkingDto;
    }

    public List<ParkingDto> getAllParkings() {
        List<Parking> parkings = parkingDao.getAllParkings();
        List<ParkingDto> parkingDtos = new ArrayList<ParkingDto>();
        for(Parking parking : parkings) {
            parkingDtos.add(new ParkingDto(parking));
        }
        return parkingDtos;
    }

    public List<ParkingDto> getAllParkingsPlus() {
        List<Parking> parkings = parkingDao.getAllParkingsPlus();
        List<ParkingDto> parkingDtos = new ArrayList<ParkingDto>();
        for(Parking parking : parkings) {
            parkingDtos.add(new ParkingDto(parking));
        }
        return parkingDtos;
    }

    public void updateParking(ParkingDto parkingDto) {
        parkingDao.updateParking(parkingDto.createParking());
    }

    public void deleteParking(Integer parkingId) {
        parkingDao.deleteParking(parkingId);
    }
}
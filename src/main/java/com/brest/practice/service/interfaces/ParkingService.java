package com.brest.practice.service.interfaces;


import com.brest.practice.dto.ParkingDto;

import java.util.List;

public interface ParkingService {

    Integer addParking(ParkingDto parkingDto);

    Integer getCountParkingByName(String parkingName);

    ParkingDto getParkingById(Integer parkingId);

    List<ParkingDto> getAllParkings();

    List<ParkingDto> getAllParkingsPlus();

    void updateParking(ParkingDto parkingDto);

    void deleteParking(Integer parkingId);

    List<ParkingDto> getParkingsByTariffId(Integer tariffId);
}
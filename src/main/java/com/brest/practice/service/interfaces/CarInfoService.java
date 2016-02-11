package com.brest.practice.service.interfaces;

import com.brest.practice.models.CarInfo;

import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */
public interface CarInfoService {
    CarInfo getCarInfoById(Long carInfoId);

    List<CarInfo> getAllCarInfo();

    List<CarInfo> getAllCarInfoPlus();
}

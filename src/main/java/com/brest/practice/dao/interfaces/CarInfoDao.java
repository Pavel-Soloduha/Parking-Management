package com.brest.practice.dao.interfaces;

import com.brest.practice.models.CarInfo;

import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */
public interface CarInfoDao {

    CarInfo getCarInfoById(Long carInfoId);

    List<CarInfo> getAllCarInfo();

    List<CarInfo> getAllCarInfoPlus();

}

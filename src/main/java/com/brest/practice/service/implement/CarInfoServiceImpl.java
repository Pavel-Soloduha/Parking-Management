package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.CarInfoDao;
import com.brest.practice.models.CarInfo;
import com.brest.practice.models.Place;
import com.brest.practice.service.interfaces.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by emergency on 2/11/16.
 */

@Service
@Transactional
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    private CarInfoDao carInfoDao;

    public static void nullificationList(List<CarInfo> carInfos) {
        for(CarInfo carInfo : carInfos) {
            Place place = carInfo.getPlace();
            place.setParking(null);
            place.setCarInfo(null);
        }
    }

    public CarInfo getCarInfoById(Long carInfoId) {
        return carInfoDao.getCarInfoById(carInfoId);
    }

    public List<CarInfo> getAllCarInfo() {
        return carInfoDao.getAllCarInfo();
    }

    public List<CarInfo> getAllCarInfoPlus() {
        return carInfoDao.getAllCarInfoPlus();
    }
}

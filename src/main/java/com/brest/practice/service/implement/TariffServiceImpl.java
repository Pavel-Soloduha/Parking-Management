package com.brest.practice.service.implement;

import com.brest.practice.dao.interfaces.TariffDao;
import com.brest.practice.dto.TariffDto;
import com.brest.practice.models.Parking;
import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emergency on 2/9/16.
 */

@Service
@Transactional
public class TariffServiceImpl implements TariffService {

    @Autowired
    private TariffDao tariffDao;

    public Integer addTariff(TariffDto tariffDto) {
        Tariff tariff = tariffDto.createTariff();
        if (tariffDao.getCountTariffByName(tariff.getTariffName()) > 0)
            throw new IllegalArgumentException();

        return tariffDao.addTariff(tariff);
    }

    public Integer getCountTariffByName(String tariffName) {
        return tariffDao.getCountTariffByName(tariffName);
    }

    public TariffDto getTariffById(Integer tariffId) {
        TariffDto tariffDto = new TariffDto(tariffDao.getTariffById(tariffId));
        return tariffDto;
    }

    public List<TariffDto> getAllTariffs() {
        List<Tariff> tariffs = tariffDao.getAllTariffs();
        List<TariffDto> tariffDtos = new ArrayList<TariffDto>();
        for(Tariff tariff : tariffs) {
            tariffDtos.add(new TariffDto(tariff));
        }
        return tariffDtos;
    }

    public List<TariffDto> getAllTariffPlus() {
        List<Tariff> tariffs = tariffDao.getAllTariffsPlus();
        List<TariffDto> tariffDtos = new ArrayList<TariffDto>();
        for(Tariff tariff : tariffs) {
            tariffDtos.add(new TariffDto(tariff));
        }
        return tariffDtos;
    }

    public void updateTariff(TariffDto tariffDto) {
        tariffDao.updateTariff(tariffDto.createTariff());
    }

    public void deleteTariff(Integer tariffId) {
        tariffDao.deleteTariff(tariffId);
    }

    public List<TariffDto> getTariffsByParkingId(Integer parkingId) {
        List<Tariff> tariffs = tariffDao.getAllTariffs();
        for (int i = tariffs.size() - 1; i >= 0; i--) {
            Tariff tariff = tariffs.get(i);
            for(Object object : tariff.getParkings().toArray()) {
                Parking parking = (Parking) object;
                if(parking.getParkingId().equals(parkingId))
                    continue;

            }
            tariffs.remove(tariff);
        }

        List<TariffDto> tariffDtos = new ArrayList<TariffDto>();
        for(Tariff tariff : tariffs) {
            tariffDtos.add(new TariffDto(tariff));
        }
        return tariffDtos;
    }
}

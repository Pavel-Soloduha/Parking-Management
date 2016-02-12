package com.brest.practice.controllers;

import com.brest.practice.dto.TariffDto;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by emergency on 2/9/16.
 */

@RestController
@RequestMapping(value = "/tariff/")
public class TariffController {

    ///tariff добавить

    @Autowired
    private TariffService tariffService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTariff(@RequestBody TariffDto tariffDto) {
        tariffService.addTariff(tariffDto);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public TariffDto getAllTariffs() {
        return tariffService.getAllTariffs();
    }

    @RequestMapping(value = "/plus", method = RequestMethod.GET)
    public TariffDto getAllTariffsPlus() {
        return tariffService.getAllTariffPlus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TariffDto getTariffById(@PathVariable(value = "id") Integer tariffId) {
        return tariffService.getTariffById(tariffId);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void updateTariff(@RequestBody TariffDto tariffDto) {
        tariffService.updateTariff(tariffDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTariff(@PathVariable(value = "id") Integer tariffId) {
        tariffService.deleteTariff(tariffId);
    }
}

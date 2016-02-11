package com.brest.practice.controllers;

import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by emergency on 2/9/16.
 */

@RestController
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @RequestMapping(value = "/tariff", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTariff(@RequestBody Tariff tariff) {
        tariffService.addTariff(tariff);
    }
}

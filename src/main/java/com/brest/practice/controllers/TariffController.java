package com.brest.practice.controllers;

import com.brest.practice.models.Tariff;
import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 * Created by emergency on 2/9/16.
 */

@RestController
public class TariffController extends WebMvcConfigurerAdapter {

    @Autowired
    private TariffService tariffService;

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/results").setViewName("results");
//    }
//
//    @RequestMapping(value="/tariff", method= RequestMethod.GET)
//    public String showForm(Tariff tariff) {
//        return "form";
//    }
//
//    @RequestMapping(value="/", method=RequestMethod.POST)
//    public String checkTariffInfo(@Valid Tariff tariff, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "form";
//        }
//
//        return "redirect:/results";
//    }

    @RequestMapping(value = "/tariff", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addTariff(@RequestBody Tariff tariff) {
        tariffService.addTariff(tariff);
    }
}

package com.brest.practice.controllers;

import com.brest.practice.service.interfaces.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by emergency on 2/9/16.
 */

@RestController

public class TariffController {

    @Autowired
    private TariffService tariffService;
}

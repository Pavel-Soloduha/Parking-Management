package com.about.java.controllers;

import com.about.java.models.Parking;
import com.about.java.service.exceptions.NoSuchObjectException;
import com.about.java.service.interfaces.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ParkingService parkingService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainpage() {
        ModelAndView mav = new ModelAndView("main");

        List<Parking> parkings;
        parkings = parkingService.getParkings();
        mav.addObject("trees", parkings);
        return mav;
    }

//    @RequestMapping(value = "/delete", method = RequestMethod.POST)
//    public String delete(@RequestParam(value = "id") Long id){
//
//        try {
//            treeService.deleteInvitation(id);
//        } catch (NoSuchObjectException e) {
//            e.printStackTrace();
//        }
//
//        return "redirect:";
//    }
//
//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String edit(@RequestParam(value = "id") Long id,
//                       @RequestParam(value = "type") String type){
//
//        treeService.updateTree(new Parking(id, type));
//        return "redirect:";
//    }
//
//    @RequestMapping(value = "/add")
//    public void add(){
//
//    }
}
package com.piotrchabros.task.population.microservice.controller;

import com.piotrchabros.task.population.microservice.rest.service.population.facade.ApiPopulationRestServiceFacadeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {

    @Autowired
    ApiPopulationRestServiceFacadeBean populationRestServiceFacadeBean;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        modelAndView.addObject("data", populationRestServiceFacadeBean);

        return modelAndView;
    }
}

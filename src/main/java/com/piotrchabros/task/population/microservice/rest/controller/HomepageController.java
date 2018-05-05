package com.piotrchabros.task.population.microservice.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Displays the homepage
 */
@Controller
public class HomepageController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

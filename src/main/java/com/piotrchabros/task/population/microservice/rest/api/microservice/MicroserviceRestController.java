package com.piotrchabros.task.population.microservice.rest.api.microservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.facade.ApiPopulationRestServiceFacadeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * This controller is used for implementing endpoints for the microservice front-end layer
 */
@RestController
@RequestMapping("/ajax")
public class MicroserviceRestController {

    @Autowired
    ApiPopulationRestServiceFacadeBean apiPopulationRestServiceFacadeBean;

    @GetMapping("/countries")
    public String getCountries(){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getCountries();
        if(response.isPresent()) {
            return response.get().toString();
        }
        else return "";
    }

    @GetMapping("/population/{country}/{date}")
    public String getLifeExpectancy(@PathVariable String country, @PathVariable String date){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getPopulationByCountryAndByDate(country, date);
        if(response.isPresent()) {
            return response.get().toString();
        }
        else return "";
    }

    @GetMapping("/lifeExpectancy/{sex}/{country}/{date}")
    public String getLifeExpectancy(@PathVariable String sex, @PathVariable String country, @PathVariable String date){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getTotalLifeExpectancyBySexCountryDate(sex, country, date);
        if(response.isPresent()){
            return response.get().toString();
        }
        else return "";
    }

}

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
 * This controller is an implementation of the backend endpoints of the microservice
 */
@RestController
@RequestMapping("/ajax")
public class MicroserviceRestController implements MicroserviceRestControllerApi {

    @Autowired
    ApiPopulationRestServiceFacadeBean apiPopulationRestServiceFacadeBean;

    @GetMapping("/countries")
    public String getCountries(){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getCountriesOptionalJsonNode();
        if(response.isPresent()) {
            return response.get().toString();
        }
        else return "";
    }

    @GetMapping("/population/{country}/{date}")
    public String getPopulation(@PathVariable String country, @PathVariable String date){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getPopulationByCountryAndByDateOptionalJsonNode(country, date);
        if(response.isPresent()) {
            return response.get().toString();
        }
        else return "";
    }

    @GetMapping("/lifeExpectancy/{sex}/{country}/{date}")
    public String getLifeExpectancy(@PathVariable String sex, @PathVariable String country, @PathVariable String date){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getTotalLifeExpectancyBySexCountryDateOptionalJsonNode(sex, country, date);
        if(response.isPresent()){
            return response.get().toString();
        }
        else return "";
    }

}

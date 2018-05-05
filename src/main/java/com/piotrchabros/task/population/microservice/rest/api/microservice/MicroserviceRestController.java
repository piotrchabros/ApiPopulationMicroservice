package com.piotrchabros.task.population.microservice.rest.api.microservice;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.persistence.entity.LifeExpectancy;
import com.piotrchabros.task.population.microservice.persistence.entity.Population;
import com.piotrchabros.task.population.microservice.persistence.service.LifeExpectancyService;
import com.piotrchabros.task.population.microservice.persistence.service.PopulationService;
import com.piotrchabros.task.population.microservice.rest.api.population.facade.ApiPopulationRestServiceFacadeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This controller is an implementation of the backend endpoints of the microservice
 */
@RestController
@RequestMapping("/ajax")
public class MicroserviceRestController implements MicroserviceRestControllerApi {

    @Autowired
    ApiPopulationRestServiceFacadeBean apiPopulationRestServiceFacadeBean;

    @Autowired
    PopulationService populationService;

    @Autowired
    LifeExpectancyService lifeExpectancyService;

    /**
     * retrieves a list of countries directly from api.population
     * @return countries or empty string
     */
    @GetMapping("/countries")
    public String getCountries(){
        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getCountriesOptionalJsonNode();
        if(response.isPresent()) {
            return response.get().toString();
        }
        else return "";
    }

    /**
     * retrieves population for the given parameters
     * first, checks for the matching population in the database, if not found fetches using rest
     * @param country
     * @param date
     * @return population or null
     */
    @GetMapping("/population/{country}/{date}")
    @ResponseBody
    public Population getPopulation(@PathVariable String country, @PathVariable String date){

        Optional<Population> optionalPopulation = populationService.findPopulation(country, date);
        if(optionalPopulation.isPresent()) {
            return optionalPopulation.get();
        }

        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getPopulationByCountryAndByDateOptionalJsonNode(country, date);
        if(response.isPresent()) {
            return populationService.addPopulation(country, date, response.get().get("total_population").get("population").intValue());
        }

        return null;
    }

    /**
     * retrieves life expectancy for the given parameters
     * if not found in the database, retrieves using the api.population rest endpoint
     * @param sex
     * @param country
     * @param date
     * @return life expectancy or null
     */
    @GetMapping("/lifeExpectancy/{sex}/{country}/{date}")
    @ResponseBody
    public LifeExpectancy getLifeExpectancy(@PathVariable String sex, @PathVariable String country, @PathVariable String date){
        Optional<LifeExpectancy> optionalLifeExpectancy = lifeExpectancyService.findLifeExpectancy(sex, country, date);
        if(optionalLifeExpectancy.isPresent()){
            return optionalLifeExpectancy.get();
        }

        Optional<JsonNode> response = apiPopulationRestServiceFacadeBean.getTotalLifeExpectancyBySexCountryDateOptionalJsonNode(sex, country, date);
        if(response.isPresent()){
            return lifeExpectancyService.addLifeExpectancy(sex, country, date, response.get().get("total_life_expectancy").floatValue());
        }

        return null;
    }

}

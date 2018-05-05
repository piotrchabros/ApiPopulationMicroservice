package com.piotrchabros.task.population.microservice.rest.api.population.facade;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.adapter.CountriesRestAdapterBean;
import com.piotrchabros.task.population.microservice.rest.api.population.adapter.LifeExpectancyRestAdapterBean;
import com.piotrchabros.task.population.microservice.rest.api.population.adapter.PopulationRestAdapterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation bundling together various adapters for the api.population
 */
@Service
public class ApiPopulationRestServiceFacadeBean implements ApiPopulationRestServiceFacade {

    @Autowired
    LifeExpectancyRestAdapterBean lifeExpectancyRestServiceAdapterBean;

    @Autowired
    PopulationRestAdapterBean populationRestServiceAdapterBean;

    @Autowired
    CountriesRestAdapterBean countriesRestAdapterBean;

    public Optional<JsonNode> getPopulationByCountryAndByDateOptionalJsonNode(String country, String date) {
        return populationRestServiceAdapterBean.getPopulationByCountryAndByDate(country, date);
    }

    public Optional<JsonNode> getTotalLifeExpectancyBySexCountryDateOptionalJsonNode(String sex, String country, String date){
        return lifeExpectancyRestServiceAdapterBean.getTotalLifeExpectancyBySexCountryDate(sex, country, date);
    }

    public Optional<JsonNode> getCountriesOptionalJsonNode(){
        return countriesRestAdapterBean.getCountries();
    }

}

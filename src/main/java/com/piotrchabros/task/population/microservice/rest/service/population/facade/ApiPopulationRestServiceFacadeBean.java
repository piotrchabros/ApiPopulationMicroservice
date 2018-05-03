package com.piotrchabros.task.population.microservice.rest.service.population.facade;

import com.piotrchabros.task.population.microservice.entities.LifeExpectancy;
import com.piotrchabros.task.population.microservice.rest.api.population.facade.ApiPopulationRestAdapterFacadeBean;
import com.piotrchabros.task.population.microservice.rest.service.population.adapter.LifeExpectancyRestServiceAdapterBean;
import com.piotrchabros.task.population.microservice.rest.service.population.adapter.PopulationRestServiceAdapterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ApiPopulationRestServiceFacadeBean implements ApiPopulationRestServiceFacade {

    @Autowired
    PopulationRestServiceAdapterBean populationRestServiceAdapterBean;

    @Autowired
    LifeExpectancyRestServiceAdapterBean lifeExpectancyRestServiceAdapterBean;

    public Optional<Float> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date) {
        return populationRestServiceAdapterBean.getTotalLifeExpectancyBySexCountryDate(sex, country, date);
    }

    public Optional<Integer> getPopulationByCountryDate(String country, String date) {
        return lifeExpectancyRestServiceAdapterBean.
    }

}

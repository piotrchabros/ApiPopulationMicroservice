package com.piotrchabros.task.population.microservice.rest.api.population.facade;

import com.piotrchabros.task.population.microservice.rest.api.population.adapter.LifeExpectancyRestRestAdapterBean;
import com.piotrchabros.task.population.microservice.rest.api.population.adapter.PopulationRestAdapterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiPopulationRestAdapterFacadeBean {

    @Autowired
    LifeExpectancyRestRestAdapterBean lifeExpectancyRestAdapterBean;

    @Autowired
    PopulationRestAdapterBean populationRestAdapterBean;

    public String getTotalLifeExpectancyURL(String sex, String country, String date)
    {
        return lifeExpectancyRestAdapterBean.getTotalLifeExpectancyURL(sex, country, date);
    }

    public String getPopulationByCountryAndDateURL(String country, String date)
    {
        return populationRestAdapterBean.getPopulationByCountryDateURL(country, date);
    }
}

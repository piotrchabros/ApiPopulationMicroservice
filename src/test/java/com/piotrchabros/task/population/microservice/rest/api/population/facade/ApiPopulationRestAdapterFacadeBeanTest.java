package com.piotrchabros.task.population.microservice.rest.api.population.facade;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.LifeExpectancyRestRestAdapterBean.BY_TOTAL;
import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.common.Constants.SEX_MALE;
import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.common.Constants.URL_SEPARATOR;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiPopulationRestAdapterFacadeBeanTest {

    @Autowired
    ApiPopulationRestAdapterFacadeBean apiPopulationRestAdapterFacadeBean;

    String
            sex = SEX_MALE,
            country = "Germany",
            dateNow = LocalDate.now().toString(),
            date = "1952-01-01";

    @Test
    public void testGetTotalLifeExpectancyURL() {
        String result = apiPopulationRestAdapterFacadeBean.getTotalLifeExpectancyURL(sex, country, dateNow);
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy/" + BY_TOTAL + URL_SEPARATOR + sex + URL_SEPARATOR + country + URL_SEPARATOR + dateNow + URL_SEPARATOR,
                result);
    }

    @Test
    public void restGetPopulationByCountryTodayURL(){
        String result = apiPopulationRestAdapterFacadeBean.getPopulationByCountryAndDateURL(country, date);
        Assert.assertEquals("http://api.population.io:80/1.0/population/" + country + URL_SEPARATOR + date, result);
    }
}
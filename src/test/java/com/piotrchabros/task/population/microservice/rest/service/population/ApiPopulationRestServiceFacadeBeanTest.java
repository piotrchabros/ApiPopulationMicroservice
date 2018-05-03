package com.piotrchabros.task.population.microservice.rest.service.population;

import com.piotrchabros.task.population.microservice.rest.service.population.facade.ApiPopulationRestServiceFacadeBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.adapter.common.Constants.SEX_FEMALE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiPopulationRestServiceFacadeBeanTest {

    @Autowired
    ApiPopulationRestServiceFacadeBean populationRestServiceFacadeBean;

    String
        sex = SEX_FEMALE,
        country = "Poland",
        dateNow = LocalDate.now().toString();

    @Test
    public void testGetTotalLifeExpentancyPerCountry(){
        Optional<Float> response = populationRestServiceFacadeBean.getTotalLifeExpectancyBySexCountryDate(sex, country, dateNow);
        Assert.assertTrue(response.isPresent());
        Assert.assertTrue(Float.class.isInstance(response.get()));
    }

}

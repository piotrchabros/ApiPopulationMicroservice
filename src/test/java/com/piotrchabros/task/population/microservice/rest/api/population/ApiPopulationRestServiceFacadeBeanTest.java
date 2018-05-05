package com.piotrchabros.task.population.microservice.rest.api.population;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.facade.ApiPopulationRestServiceFacadeBean;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.Constants.SEX_SEGMENT_FEMALE;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiPopulationRestServiceFacadeBeanTest {

    @Autowired
    ApiPopulationRestServiceFacadeBean populationRestServiceFacadeBean;

    String
        sex = SEX_SEGMENT_FEMALE,
        country = "Poland",
        dateNow = LocalDate.now().toString();

    @Test
    public void testGetTotalLifeExpentancyPerCountry(){
        Optional<JsonNode> result = populationRestServiceFacadeBean.getTotalLifeExpectancyBySexCountryDateOptionalJsonNode(sex, country, dateNow);
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void testGetPopulationByCountryToday()
    {
        Optional<JsonNode> result = populationRestServiceFacadeBean.getPopulationByCountryAndByDateOptionalJsonNode(country, dateNow);
        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void testGetCountries()
    {
        Optional<JsonNode> result = populationRestServiceFacadeBean.getCountriesOptionalJsonNode();
        Assert.assertTrue(result.isPresent());
    }
}

package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.ApiPopulationConstants.SEX_SEGMENT_MALE;

/**
 * Test of the life expectancy endpoints of the api.population
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LifeExpectancyRestAdapterBeanTest {

    @Autowired
    LifeExpectancyRestAdapterBean lifeExpectancyRestAdapterBean;

    String
        sex = SEX_SEGMENT_MALE,
        country = "Poland",
        date = "1952-01-01";


    /**
     * Checks whether the base uri is properly formatted
     */
    @Test
    public void testGetBaseUri() {
        UriBuilder result = lifeExpectancyRestAdapterBean.getBaseUri();
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy", result.toString());
    }

    /**
     * Checks whether the request uri is properly formatted
     */
    @Test
    public void testGetTotalLifeExpectancyBySexCountryDateUri() {
        URI uri = lifeExpectancyRestAdapterBean.getTotalLifeExpectancyBySexCountryDateUri(sex, country, date);
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy/total/"+sex+"/"+country+"/"+date+"?format=json", uri.toString());
    }

    /**
     * Checks whether the life expectancy response exists and is properly formatted
     */
    @Test
    public void test() {
        Optional<JsonNode> response = lifeExpectancyRestAdapterBean.getTotalLifeExpectancyBySexCountryDate(sex, country, date);
        Assert.assertTrue(response.isPresent());
        JsonNode json = response.get();
        Assert.assertEquals(country, json.get("country").asText());
        Assert.assertEquals(date, json.get("dob").asText());
        Assert.assertEquals(sex, json.get("sex").asText());
    }
}
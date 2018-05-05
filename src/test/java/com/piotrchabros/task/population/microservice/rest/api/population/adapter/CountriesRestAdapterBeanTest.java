package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;
import java.util.Optional;

/**
 * Test of the countries endpoints of the api.population
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesRestAdapterBeanTest {

    @Autowired
    CountriesRestAdapterBean countriesRestAdapterBean;

    String url = "http://api.population.io:80/1.0/countries";

    /**
     * Checks whether the base uri is properly formatted
     */
    @Test
    public void testGetCountriesBaseUri() {
        Assert.assertEquals(url, countriesRestAdapterBean.getBaseUri().toString());
    }

    /**
     * Checks whether the countries fetched from the api.population exists
     */
    @Test
    public void testGetCountries(){
        Optional<JsonNode> response = countriesRestAdapterBean.getCountries();
        Assert.assertTrue(response.isPresent());
        JsonNode json = response.get();
        Assert.assertTrue(json.get("countries").isArray());
    }

}

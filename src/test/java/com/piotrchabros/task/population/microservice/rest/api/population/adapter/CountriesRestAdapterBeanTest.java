package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesRestAdapterBeanTest {

    @Autowired
    CountriesRestAdapterBean countriesRestAdapterBean;

    String url = "http://api.population.io:80/1.0/countries";

    @Test
    public void testGetCountriesBaseUrlString() {
        Assert.assertEquals(url, countriesRestAdapterBean.getBaseUri().toString());
    }

    @Test
    public void testGetCountries(){
        Assert.assertTrue(countriesRestAdapterBean.getCountries().isPresent());
    }

}

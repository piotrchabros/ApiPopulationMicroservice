package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulationRestAdapterBeanTest {

    @Autowired
    PopulationRestAdapterBean populationRestAdapterBean;

    String country = "Poland";
    String date;

    @Test
    public void testGetBaseUri(){
        UriBuilder uri = populationRestAdapterBean.getBaseUri();
        Assert.assertEquals("http://api.population.io:80/1.0/population", uri.toTemplate());
    }

    @Test
    public void testGetPopulationByCountryTodayURL()
    {
        date = LocalDate.now().toString();
        URI uri = populationRestAdapterBean.getPopulationByCountryAndByDateUrlString(country, date);
        Assert.assertEquals("http://api.population.io:80/1.0/population/" + country + "/" + date+"?format=json", uri.toString());
    }
}
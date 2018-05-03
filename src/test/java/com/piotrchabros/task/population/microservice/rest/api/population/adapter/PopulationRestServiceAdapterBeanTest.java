package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulationRestServiceAdapterBeanTest {

    @Autowired
    PopulationRestAdapterBean populationRestAdapterBean;

    String country = "Poland";
    String date;

    @Test
    public void testGetBaseUri(){
        UriBuilder uri = populationRestAdapterBean.getBaseUri();
        Assert.assertEquals("http://api.population.io:80/1.0/population/", uri.toString());
    }

    @Test
    public void testGetPopulationByCountryTodayURL()
    {
        date = LocalDate.now().toString();
        String url = populationRestAdapterBean.getPopulationByCountryDateURL(country, date);
        Assert.assertEquals("http://api.population.io:80/1.0/population/" + country + "/" + date, url);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
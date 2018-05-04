package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LifeExpectancyRestAdapterBeanTest {

    @Autowired
    LifeExpectancyRestAdapterBean lifeExpectancyRestAdapterBean;

    @Test
    public void testGetBaseUri() {
        UriBuilder result = lifeExpectancyRestAdapterBean.getBaseUri();
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy", result.toString());
    }

    @Test
    public void testGetTotalLifeExpectancyURL() {
        URI uri = lifeExpectancyRestAdapterBean.getTotalLifeExpectancyBySexCountryDateUrlString("male", "United Kingdom", "1952-01-01");
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy/total/male/United%20Kingdom/1952-01-01", uri.toString());
    }
}
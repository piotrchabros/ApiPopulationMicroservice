package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LifeExpectancyRestAdapterBeanTest {

    @Autowired
    LifeExpectancyRestRestAdapterBean lifeExpectancyRestAdapterBean;

    @Test
    public void testGetBaseUri() {
        UriBuilder result = lifeExpectancyRestAdapterBean.getBaseUri();
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy/", result.toString());
    }

    @Test
    public void testGetTotalLifeExpectancyURL() {
        String result = lifeExpectancyRestAdapterBean.getTotalLifeExpectancyURL("male", "United Kingdom", "1952-01-01");
        Assert.assertEquals("http://api.population.io:80/1.0/life-expectancy/total/male/United%20Kingdom/1952-01-01/", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.tomcat.jni.Local;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PopulationRestAdapterBeanTest {

    @Autowired
    PopulationRestAdapterBean populationRestAdapterBean;

    String
            country = "Poland",
            date = LocalDate.now().toString();

    /**
     * Checks whether the base uri is properly formatted
     */
    @Test
    public void testGetBaseUriBuilder(){
        UriBuilder uri = populationRestAdapterBean.getBaseUriBuilder();
        Assert.assertEquals("http://api.population.io:80/1.0/population", uri.toTemplate());
    }

    /**
     * Checks if the uri is properly formed
     */
    @Test
    public void getPopulationByCountryAndByDateUri()
    {
        URI uri = populationRestAdapterBean.getPopulationByCountryAndByDateUri(country, date);
        Assert.assertEquals("http://api.population.io:80/1.0/population/" + country + "/" + date+"?format=json", uri.toString());
    }

    /**
     * Checks if the fetched population exists and is valid
     */
    @Test
    public void testGetPopulationByCountryAndByDate(){
        Optional<JsonNode> response = populationRestAdapterBean.getPopulationByCountryAndByDate(country, date);
        Assert.assertTrue(response.isPresent());
        JsonNode json = response.get();
        Assert.assertEquals(date, json.get("total_population").get("date").asText());
    }
}
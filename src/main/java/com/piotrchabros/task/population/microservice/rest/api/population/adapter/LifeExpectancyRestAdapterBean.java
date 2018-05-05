package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.utils.ResponseEntityJsonMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.ApiPopulationConstants.*;

/**
 * Adapter class implementation for retrieving the life expectancy data from api.population
 * Each adapter has a different uri format that can be adapted accordingly to the api.population
 */
@Service
public class LifeExpectancyRestAdapterBean implements LifeExpectancyRestAdapter {

    public UriBuilder getBaseUri(){
        return UriBuilder.fromPath(BASE_URL + LIFE_EXPECTANCY).scheme(BASE_HOST);
    }

    public URI getTotalLifeExpectancyBySexCountryDateUri(String sex, String country, String date){
        return getBaseUri()
                .segment(TOTAL_SEGMENT, SEX_SEGMENT, COUNTRY_SEGMENT, DATE_SEGMENT)
                .queryParam(FORMAT, FORMAT_JSON)
                .build(TOTAL_SEGMENT_VALUE, sex, country, date);
    }

    public Optional<JsonNode> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date) {
        URI uri = getTotalLifeExpectancyBySexCountryDateUri(sex, country, date);
        return ResponseEntityJsonMapper.getOptionalJsonResponse(uri, String.class);
    }

}

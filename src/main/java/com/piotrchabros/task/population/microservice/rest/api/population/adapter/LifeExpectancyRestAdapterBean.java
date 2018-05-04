package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.utils.ResponseEntityJsonMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.Constants.*;

@Service
public class LifeExpectancyRestAdapterBean implements LifeExpectancyRestAdapter {

    public UriBuilder getBaseUri(){
        return UriBuilder.fromPath(BASE_URL + LIFE_EXPECTANCY).scheme(BASE_HOST);
    }

    public URI getTotalLifeExpectancyBySexCountryDateUrlString(String sex, String country, String date){
        return getBaseUri()
                .segment(TOTAL_SEGMENT, SEX_SEGMENT, COUNTRY_SEGMENT, DATE_SEGMENT)
                .queryParam(FORMAT, FORMAT_JSON)
                .build(TOTAL_SEGMENT_VALUE, sex, country, date);
    }

    public Optional<JsonNode> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date) {
        URI uri = getTotalLifeExpectancyBySexCountryDateUrlString(sex, country, date);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return ResponseEntityJsonMapper.getOptionalJsonResponse(response);
    }

}

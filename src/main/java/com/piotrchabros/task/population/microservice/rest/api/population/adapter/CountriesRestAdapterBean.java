package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.utils.ResponseEntityJsonMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.UriBuilder;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.Constants.*;

/**
 * concrete implementation of the CountriesRestAdapter interface
 */
@Service
public class CountriesRestAdapterBean implements CountriesRestAdapter {

    public UriBuilder getBaseUri(){
        return UriBuilder.fromPath(BASE_URL + COUNTRIES).scheme(BASE_HOST);
    }

    public Optional<JsonNode> getCountries() {
        String url = getBaseUri().queryParam(FORMAT, FORMAT_JSON).toTemplate();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return ResponseEntityJsonMapper.getOptionalJsonResponse(response);
    }

}

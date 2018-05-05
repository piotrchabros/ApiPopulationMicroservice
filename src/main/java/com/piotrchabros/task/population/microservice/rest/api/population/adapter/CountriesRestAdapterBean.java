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

/**
 * Adapter class implementation for retrieving the countries data from api.population
 * Each adapter has a different base uri format that can be adapted accordingly to needs
 */
@Service
public class CountriesRestAdapterBean implements CountriesRestAdapter {

    public UriBuilder getBaseUri(){
        return UriBuilder.fromPath(BASE_URL + COUNTRIES).scheme(BASE_HOST);
    }

    public URI getCountriesUri(){
        return getBaseUri().queryParam(FORMAT, FORMAT_JSON).build();
    }

    public Optional<JsonNode> getCountries() {
        URI uri = getCountriesUri();
        return ResponseEntityJsonMapper.getOptionalJsonResponse(uri, String.class);
    }

}

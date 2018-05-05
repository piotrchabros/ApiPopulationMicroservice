package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.utils.ResponseEntityJsonMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.ApiPopulationConstants.*;

/**
 * Adapter class implementation for retrieving the countries data from api.population
 * Each adapter has a different uri format that can be adapted accordingly to the api.population
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

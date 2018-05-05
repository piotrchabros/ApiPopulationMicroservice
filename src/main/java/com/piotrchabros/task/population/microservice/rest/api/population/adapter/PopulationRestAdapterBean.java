package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;
import com.piotrchabros.task.population.microservice.rest.api.population.utils.ResponseEntityJsonMapper;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Optional;

import static com.piotrchabros.task.population.microservice.rest.api.population.common.Constants.*;

/**
 * Adapter class implementation for retrieving the population data from api.population
 * Each adapter has a different base uri format that can be adapted accordingly to needs
 */
@Service
public class PopulationRestAdapterBean implements PopulationRestAdapter {

    public UriBuilder getBaseUriBuilder(){
        return UriBuilder.fromPath(BASE_URL + POPULATION).scheme(BASE_HOST);
    }

    public URI getPopulationByCountryAndByDateUri(String country, String date) {
        return getBaseUriBuilder()
                .segment(COUNTRY_SEGMENT, DATE_SEGMENT)
                .queryParam(FORMAT, FORMAT_JSON)
                .build(country, date);
    }

    public Optional<JsonNode> getPopulationByCountryAndByDate(String country, String date) {
        URI uri = getPopulationByCountryAndByDateUri(country, date);
        return ResponseEntityJsonMapper.getOptionalJsonResponse(uri, String.class);
    }
}

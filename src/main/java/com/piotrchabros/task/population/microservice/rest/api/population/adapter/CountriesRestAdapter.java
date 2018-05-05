package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

/**
 * countries : list available countries
 * Provides an interface for communicating with the api.population
 */
public interface CountriesRestAdapter {


    /**
     * Return a list of all countries in the statistical dataset.
     * These are also the valid input values to the various 'country' parameters across the remaining API.
     * @return json array response
     */
    Optional<JsonNode> getCountries();

}

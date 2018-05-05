package com.piotrchabros.task.population.microservice.rest.api.population.facade;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

/**
 * Interface bundling together various methods of rest adapters for the population api
 * It acts like a gateway for other services/components in order to request data
 */
public interface ApiPopulationRestServiceFacade {

    /**
     * Retrieves the total life expectancy using population api.
     * @param sex
     * @param country
     * @param date
     * @return optional json response
     */
    Optional<JsonNode> getTotalLifeExpectancyBySexCountryDateOptionalJsonNode(String sex, String country, String date);

    /**
     * Determines total population for a given country on a given date. Valid dates are 2013-01-01 to 2022-12-31.
     * @param country
     * @param date
     * @return optional json response
     */
    Optional<JsonNode> getPopulationByCountryAndByDateOptionalJsonNode(String country, String date);

    /**
     * Return a list of all countries in the statistical dataset.
     * These are also the valid input values to the various 'country' parameters across the remaining API.
     * @return optional json response
     */
    Optional<JsonNode> getCountriesOptionalJsonNode();
}

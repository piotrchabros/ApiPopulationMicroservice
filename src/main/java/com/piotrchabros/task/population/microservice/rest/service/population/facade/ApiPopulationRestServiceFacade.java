package com.piotrchabros.task.population.microservice.rest.service.population.facade;

import java.util.Optional;

/**
 * Bundles together various methods of rest adapters for the population api
 */
public interface ApiPopulationRestServiceFacade {

    /**
     * Retrieves the total life expectancy using population api. In case of error returns empty optional
     * @param sex
     * @param country
     * @param date
     * @return optional life expectancy (float)
     */
    Optional<Float> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date);
}

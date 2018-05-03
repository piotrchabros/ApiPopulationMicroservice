package com.piotrchabros.task.population.microservice.rest.service.population.adapter;

import java.util.Optional;

public interface PopulationRestServiceAdapter {

    /**
     * Retrieves the total life expectancy using population api. In case of error returns empty optional
     * @param sex
     * @param country
     * @param date
     * @return optional life expectancy (float)
     */
    Optional<Float> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String date);
}

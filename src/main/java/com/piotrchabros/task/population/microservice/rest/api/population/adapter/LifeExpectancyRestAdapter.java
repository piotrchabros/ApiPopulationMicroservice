package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

/**
 * life-expectancy : calculate life expectancy
 */
public interface LifeExpectancyRestAdapter {

    /**
     * Calculate total life expectancy of a person with given sex, country, and date of birth.
     * Note that this function is implemented based on the remaining life expectancy by picking a reference date based on an age of 35 years. It is therefore of limited accuracy.
     * @param sex
     * @param country
     * @param dateOfBirth
     * @return optional json response
     */
    Optional<JsonNode> getTotalLifeExpectancyBySexCountryDate(String sex, String country, String dateOfBirth);

}

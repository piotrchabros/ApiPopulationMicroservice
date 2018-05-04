package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.Optional;

public interface PopulationRestAdapter {

    /**
     * Determines total population for a given country on a given date. Valid dates are 2013-01-01 to 2022-12-31.
     * @param country
     * @param date
     * @return optional json response
     */
     Optional<JsonNode> getPopulationByCountryAndByDate(String country, String date);


}

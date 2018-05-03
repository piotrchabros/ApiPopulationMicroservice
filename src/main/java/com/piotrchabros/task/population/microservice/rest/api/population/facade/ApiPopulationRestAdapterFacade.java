package com.piotrchabros.task.population.microservice.rest.api.population.facade;

/**
 * Bundles together various methods of rest api adapters for the population api
 */
public interface ApiPopulationRestAdapterFacade {

    /**
     * Calculate total life expectancy of a person with given sex, country, and date of birth.
     * Note that this function is implemented based on the remaining life expectancy by picking a reference date based on an age of 35 years. It is therefore of limited accuracy.
     * @param sex
     * @param country
     * @param dateOfBirth
     * @return
     */
    String getTotalLifeExpectancyURL(String sex, String country, String dateOfBirth);


    /**
     * Determines total population for a given country on a given date. Valid dates are 2013-01-01 to 2022-12-31.
     * @param country
     * @param date
     * @return
     */
    String getPopulationByCountryAndDateURL(String country, String date);
}

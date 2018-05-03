package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

public interface PopulationRestAdapter {

    /**
     * Retrieve population table for all countries and a specific age group in the given year.
     * @param year
     * @param age
     * @return
     */
    String getPopulationByYearAndAge(String year, String age);


    /**
     * Retrieve population table for a specific age group in the given year and country.
     * @param year
     * @param country
     * @param age
     * @return
     */
    String getPopulationByYearCountryAge(String year, String country, String age);

    /**
     * Retrieve population tables for a given year and country. Returns tables for all ages from 0 to 100.
     * @param year
     * @param country
     * @return
     */
    String getPopulationByYearAndCountry(String year, String country);

    /**
     * Retrieve population tables for a specific age group in the given country. Returns tables for all years from 1950 to 2100.
     * @param country
     * @param age
     * @return
     */
    String getPopulationByCountryAndByAge(String country, String age);


    /**
     * Determines total population for a given country on a given date. Valid dates are 2013-01-01 to 2022-12-31.
     * @param country
     * @param date
     * @return
     */
    String getPopulationByCountryAndByDate(String country, String date);

    /**
     * Determines total population for a given country with separate results for today and tomorrow.
     * @param country
     * @return
     */
    String getPopulationByCountryTodayAndTomorrow(String country);
}

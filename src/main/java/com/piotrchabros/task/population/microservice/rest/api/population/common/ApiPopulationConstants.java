package com.piotrchabros.task.population.microservice.rest.api.population.common;

/**
 * These are constant variables that are required to build requests and fetch data
 */
public class ApiPopulationConstants {

    public static final String BASE_HOST = "http";
    public final static String BASE_URL =  "//api.population.io:80/1.0/";

    public final static String FORMAT = "format";
    public final static String FORMAT_JSON = "json";

    public final static String COUNTRIES = "countries";
    public final static String POPULATION = "population";
    public final static String LIFE_EXPECTANCY = "life-expectancy";


    public final static String POPULATION_SEGMENT = "{population}";
    public static final String COUNTRY_SEGMENT = "{country}";
    public static final String DATE_SEGMENT = "{date}";
    public final static String SEX_SEGMENT = "{sex}";
    public final static String TOTAL_SEGMENT = "{total}";
    public final static String TOTAL_SEGMENT_VALUE = "total";
    public final static String SEX_SEGMENT_MALE = "male";
    public final static String SEX_SEGMENT_FEMALE = "female";
}

package com.piotrchabros.task.population.microservice.rest.api.population.adapter;

public interface LifeExpectancyRestAdapter {

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
     * Calculate remaining life expectancy of a person with given sex, country, and age at a given point in time.
     * @param sex
     * @param country
     * @param date
     * @param age
     * @return
     */
    String getRemainingLifeExpectancyURL(String sex, String country, String date, String age);

    /**
     * Calculate diabetes life expectancy of a person with given sex, country, age and whether has diabetes or not.
     * @param hasDiabetes
     * @param sex
     * @param country
     * @param age
     * @return
     */
    String gerRemainingLifeExpectancyWithDiabetesURL(String hasDiabetes, String sex, String country, String age);

}

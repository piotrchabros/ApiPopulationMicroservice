package com.piotrchabros.task.population.microservice.rest.api.microservice;

import com.piotrchabros.task.population.microservice.persistence.entity.LifeExpectancy;
import com.piotrchabros.task.population.microservice.persistence.entity.Population;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * public interface of the microservice rest api endpoints for the backend
 */
public interface MicroserviceRestControllerApi {

    /**
     * a method returning a list of all countries
     * @return string representation of a json response object
     */
    String getCountries();

    /**
     * a method returning a population for the given parameters
     * @param country
     * @param date
     * @return string representation of a json response object
     */
    Population getPopulation(@PathVariable String country, @PathVariable String date);

    /**
     * a method returning a life expectancy for the given parameters
     * @param sex
     * @param country
     * @param date
     * @return string representation of a json response object
     */
    LifeExpectancy getLifeExpectancy(@PathVariable String sex, @PathVariable String country, @PathVariable String date);
}

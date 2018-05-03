package com.piotrchabros.task.population.microservice.entities;

import lombok.Data;

import java.util.Date;

public @Data class Country {
    private Date dateUpdated;
    private String countryName;
    private Population population;
    private LifeExpectancy expectancy;
}

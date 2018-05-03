package com.piotrchabros.task.population.microservice.entities;

import lombok.Data;

import java.util.Date;

public @Data class LifeExpectancy {

    private Date dateUpdated;
    private Country country;
    private int expectancy;

}

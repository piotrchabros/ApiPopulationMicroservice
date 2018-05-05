package com.piotrchabros.task.population.microservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This entity is a data model for storing life expectancy in the temporary databsae
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LifeExpectancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String sex;
    private String country;
    private String dateOfBirth;
    private float lifeExpectancy;
}

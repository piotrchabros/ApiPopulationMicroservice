package com.piotrchabros.task.population.microservice.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This entity is a data model for storing population in the temporary database
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Population {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String date;
    private int population;

}

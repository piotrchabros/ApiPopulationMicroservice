package com.piotrchabros.task.population.microservice.persistence.service;

import com.piotrchabros.task.population.microservice.persistence.entity.Population;
import com.piotrchabros.task.population.microservice.persistence.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for interaction between the population repository and other modules
 */
@Service
public class PopulationService {

    @Autowired
    PopulationRepository populationRepository;

    public Optional<Population> findPopulation(String country, String date){
        Population result = populationRepository.getPopulation(country, date);
        if(result != null){
            return Optional.of(result);
        }
        return Optional.empty();
    }

    public Population addPopulation(String country, String date, int population){
        return populationRepository.addPopulation(new Population(null, country, date, population));
    }
}

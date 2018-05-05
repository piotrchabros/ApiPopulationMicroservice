package com.piotrchabros.task.population.microservice.persistence.service;

import com.piotrchabros.task.population.microservice.persistence.entity.LifeExpectancy;
import com.piotrchabros.task.population.microservice.persistence.repository.LifeExpectancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for interaction between the life expectancy repository and other modules
 */
@Service
public class LifeExpectancyService {

    @Autowired
    LifeExpectancyRepository lifeExpectancyRepository;

    public LifeExpectancy addLifeExpectancy(String sex, String country, String dateOfBirth, float lifeExpectancy){
        return lifeExpectancyRepository.addLifeExpectancy(new LifeExpectancy(null, sex, country, dateOfBirth, lifeExpectancy));
    }

    public Optional<LifeExpectancy> findLifeExpectancy(String sex, String country, String dateOfBirth){
        LifeExpectancy lifeExpectancy = lifeExpectancyRepository.getLifeExpectancy(sex, country, dateOfBirth);
        if(lifeExpectancy == null){
            return Optional.empty();
        }
        else return Optional.of(lifeExpectancy);
    }
}

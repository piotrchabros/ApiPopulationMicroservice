package com.piotrchabros.task.population.microservice.repository;

import com.piotrchabros.task.population.microservice.entities.Country;
import com.piotrchabros.task.population.microservice.entities.Population;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
@Repository
public class PopulationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Population getPopulationByCountry(Country country)
    {
        return null;
        //String hql = "FROM Population WHERE country = :username";
        //return  (Population) entityManager.createQuery(hql).setParameter("username", username).getResultList().get(0);
    }

}

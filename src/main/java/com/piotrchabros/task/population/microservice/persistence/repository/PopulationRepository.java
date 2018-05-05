package com.piotrchabros.task.population.microservice.persistence.repository;

import com.piotrchabros.task.population.microservice.persistence.entity.Population;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Implements direct access to the repository, using hibernate query language (hql)
 */
@Transactional
@Repository
public class PopulationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Population addPopulation(Population population){
        entityManager.persist(population);
        return population;
    }

    public Population getPopulation(String country, String date){
        String hql = "FROM Population WHERE country = :country AND date = :date";
        List resultList = entityManager.createQuery(hql)
                .setParameter("country", country)
                .setParameter("date", date)
                .getResultList();
        if(resultList.isEmpty()){
            return null;
        }
        else{
            return (Population) resultList.get(0);
        }
    }
}

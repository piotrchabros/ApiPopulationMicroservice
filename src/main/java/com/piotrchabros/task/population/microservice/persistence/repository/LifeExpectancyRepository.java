package com.piotrchabros.task.population.microservice.persistence.repository;

import com.piotrchabros.task.population.microservice.persistence.entity.LifeExpectancy;
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
public class LifeExpectancyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public LifeExpectancy addLifeExpectancy(LifeExpectancy lifeExpectancy){
        entityManager.persist(lifeExpectancy);
        return lifeExpectancy;
    }

    public LifeExpectancy getLifeExpectancy(String sex, String country, String date){
        String hql = "FROM LifeExpectancy WHERE sex = :sex AND country = :country AND dateOfBirth = :dateOfBirth";
        List resultList = entityManager.createQuery(hql)
                .setParameter("sex", sex)
                .setParameter("country", country)
                .setParameter("dateOfBirth", date)
                .getResultList();
        if(resultList.isEmpty()){
            return null;
        }
        return (LifeExpectancy)resultList.get(0);
    }

}

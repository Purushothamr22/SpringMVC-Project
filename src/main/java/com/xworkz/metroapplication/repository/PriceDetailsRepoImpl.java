package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.PriceDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
@Slf4j

public class PriceDetailsRepoImpl implements  PriceDetailsRepo{
    @Autowired
    private EntityManagerFactory entityManagerFactory;


    @Override
    public String savePriceDetails(PriceDetailsEntity trainPriceDetailsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(trainPriceDetailsEntity);
            transaction.commit();
        }catch (Exception e){
            log.error("error in savePriceDetails repo ..........................  "  +e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public PriceDetailsEntity findPriceBySourceAndDestination(String source, String destination) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findPriceBySourceAndDestination");
            query.setParameter("source",source);
            query.setParameter("destination",destination);
            return  (PriceDetailsEntity) query.getSingleResult();
        }catch (Exception e){
            log.error("error in findPriceBySourceAndDestination repo ..............." +e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<PriceDetailsEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findAllPrice");

            List<PriceDetailsEntity> resultList = query.getResultList();
            return  resultList;
        }catch (Exception e){
            log.error("error in findPriceByTrainTypeSourceAndDestination repo ..............." +e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }
}

package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
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


public class TrainTimeDetailsRepoImpl implements TrainTimeDetailsRepo {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public String saveTimeDetails(TrainTimeDetailsEntity trainTimeDetailsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        log.info("the given data to the repo is ....................    "+trainTimeDetailsEntity);
        try {
            transaction.begin();

            entityManager.persist(trainTimeDetailsEntity);

            transaction.commit();
        }catch (Exception e){
            log.info("error in saveTimeDetails ............." +e.getMessage());
        }
        finally {
            entityManager.close();
        }
        return "Save Error";
    }

    @Override
    public TrainTimeDetailsEntity findBySourceAndDestination(String source, String destination) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findBySourceAndDestination");
            query.setParameter("source",source);
            query.setParameter("destination",destination);
            return  (TrainTimeDetailsEntity) query.getSingleResult();
        }catch (Exception e){
            log.error("got error in findBySourceAndDestination.....................  " +e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<TrainTimeDetailsEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findAllTime");
            List<TrainTimeDetailsEntity>  resultList = query.getResultList();
            return resultList;
        }catch (Exception e){
            log.error("got error in findBySource.....................  " +e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public TrainTimeDetailsEntity findByTrainId(Integer trainId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByTrainId");
            query.setParameter("trainId",trainId);
            return (TrainTimeDetailsEntity) query.getSingleResult();
        }catch (Exception e ){
            log.error("error in findByTrainId repo    "+e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }
}

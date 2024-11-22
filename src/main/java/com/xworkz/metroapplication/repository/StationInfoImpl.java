package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;
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

public class StationInfoImpl implements StationInfoRepo {
   @Autowired
    private EntityManagerFactory entityManagerFactory;
    @Override
    public String saveTrainDetails(StationDetailsEntity trainDetailsEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(trainDetailsEntity);
            transaction.commit();
        }catch (Exception e){
            log.error("got error in save train details ......................     "+e.getMessage());
        }finally {
            entityManager.close();
        }
        return "failed to save ";
    }
    @Override
    public StationDetailsEntity findByStationName(String stationName) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByStationName");
            query.setParameter("stationName",stationName);
            return (StationDetailsEntity) query.getSingleResult();
        }catch (Exception e){
            log.error("got error in find  by Station Name......"+e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<StationDetailsEntity> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findAllStation");
            List<StationDetailsEntity>  resultList = query.getResultList();
            return resultList;
        }catch (Exception e){
            log.error("got error in find  by Station Name......"+e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public StationDetailsEntity findById(Integer stationId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findById");
            query.setParameter("stationId",stationId);
            return (StationDetailsEntity) query.getSingleResult();
        }catch (Exception e){
            log.error("error in findById repo "+e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }
}

package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
@Slf4j

public class UserInteractionRepoImpl implements UserInteractionRepo {
@Autowired
    EntityManagerFactory entityManagerFactory;
    @Override
    public TrainTimeDetailsEntity findSourceDestinationDetails(String source, String destination) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("FindSandD");
            query.setParameter("source",source);
            query.setParameter("destination",destination);
            TrainTimeDetailsEntity result = (TrainTimeDetailsEntity) query.getSingleResult();
            log.info("the entity in repo is ============================ {}",result);
            return result;
        }catch (Exception e){
            log.error("error in findSourceDetails repo ========================= {}",e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<StationDetailsEntity> findStationDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findStationDetails");
            List<StationDetailsEntity> resultList = query.getResultList();

            return resultList;
        }catch (Exception e){
            log.error("error in findStationDetails repo ============ {}",e.getMessage());
        }finally {
            entityManager.close();

        }
        return null;
    }
    @Override
    public List<TrainTimeDetailsEntity> findAllDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findAllDetails");
            List<TrainTimeDetailsEntity> resultList = query.getResultList();
            return resultList;
        }catch (Exception e){
            log.error("error in findStationDetails repo ============ {}",e.getMessage());
        }finally {
            entityManager.close();

        }
        return null;
    }

}

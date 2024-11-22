package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.DisplayMetroDetailsEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class DisplayDetailsRepoImpl implements DisplayDetailsRepo {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<DisplayMetroDetailsEntity> getMetroDetails() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("metroList");
            List<Object[]> resultList = query.getResultList();
            transaction.commit();
            List<DisplayMetroDetailsEntity> metroDetailsEntities = setDetails(resultList);
            return metroDetailsEntities;
        } catch (Exception e) {
            log.info("Exception in getMetroDetails: " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
    }

    private  List<DisplayMetroDetailsEntity> setDetails( List<Object[]> resultList){
        List<DisplayMetroDetailsEntity> details = new ArrayList<>();
        for (Object[] result : resultList) {
            DisplayMetroDetailsEntity entity = new DisplayMetroDetailsEntity();
            entity.setId((Integer) result[0]);
            entity.setTrainNumber((String) result[1]);
            entity.setTrainType((String) result[2]);
            entity.setStationName((String) result[3]);
            entity.setFromDay((String) result[4]);
            entity.setToDay((String) result[5]);
            entity.setSource((String) result[6]);
            entity.setDestination((String) result[7]);
            entity.setSourceTime((String) result[8]);
            entity.setDestinationTime((String) result[9]);
            entity.setPrice((String) result[10]);
            details.add(entity);
        }
        return details;
    }
}

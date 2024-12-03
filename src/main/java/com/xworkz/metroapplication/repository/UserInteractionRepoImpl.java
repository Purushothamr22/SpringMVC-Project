package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TicketBookingEntity;
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
    public String updateTicketPrice(String price,Integer trainId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("updateTicketPrice");
            transaction.begin();
            query.setParameter("price",price);
            query.setParameter("trainId",trainId);
            query.executeUpdate();
            transaction.commit();
            return "Price Saved";
        }catch (Exception e){
            log.error("error in updatePrice repo  ====================  {}",e.getMessage());
            return "Save Error";
        }finally {
            entityManager.close();
        }

    }

    @Override
    public String saveTicketDetails(TicketBookingEntity ticketBookingEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(ticketBookingEntity);
            transaction.commit();
            return "Save Success";
        }catch (Exception e){
            log.error("error in saveTicketDetails repo =============== {} ",e.getMessage());
            return "Save Error";
        }finally {
            entityManager.close();
        }

    }

}

package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TicketBookingEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;
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
            query.setParameter("source", source);
            query.setParameter("destination", destination);
            TrainTimeDetailsEntity result = (TrainTimeDetailsEntity) query.getSingleResult();
            log.info("the entity in repo is ============================ {}", result);
            return result;
        } catch (Exception e) {
            log.error("error in findSourceDetails repo ========================= {}", e.getMessage());
        } finally {
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
        } catch (Exception e) {
            log.error("error in findStationDetails repo ============ {}", e.getMessage());
        } finally {
            entityManager.close();
        }
        return null;
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
        } catch (Exception e) {
            log.error("error in saveTicketDetails repo =============== {} ", e.getMessage());
            return "Save Error";
        } finally {
            entityManager.close();
        }

    }

    @Override
    public UserRegistrationEntity findByUserIdRepo(Integer userRegistrationId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("findByUserId");
            transaction.begin();
            query.setParameter("userRegistrationId", userRegistrationId);
            UserRegistrationEntity result = (UserRegistrationEntity) query.getSingleResult();
            transaction.commit();
            return result;
        } catch (Exception e) {
            log.error("Exception in findByUserIdRepo ========= {}", e.getMessage());
            return null;
        }
    }

    @Override
    public String updateUserProfileRepo(UserRegistrationEntity userRegistrationEntity) {
        log.info("Entity given to repo is ++++++++++++++++++++ {}",userRegistrationEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(userRegistrationEntity);
            transaction.commit();
            return "Profile updated";
        } catch (Exception e) {
            log.error("error in update profile " + e.getMessage());
        } finally {
            entityManager.close();
        }
        return "user not updated";
    }

    @Override
    public List<TicketBookingEntity> getBookingDetails(Integer userLoginId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("findByUserLoginId");
            transaction.begin();
            query.setParameter("userLoginId", userLoginId);
            List<TicketBookingEntity> resultList = query.getResultList();
            transaction.commit();
//            log.info("List of booking details entity is ==============   {}",resultList);
            return resultList;
        } catch (Exception e) {
            log.error("Exception in findByUserIdRepo ========= {}", e.getMessage());
            return null;
        }
    }

    @Override
    public TicketBookingEntity getHistoryByTid(String tokenNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("findByTokenNumber");
            transaction.begin();
            query.setParameter("tokenNumber", tokenNumber);
            TicketBookingEntity result = (TicketBookingEntity) query.getSingleResult();
            transaction.commit();
            log.info(" booking details entity is ==============   {}",result);
            return result;
        } catch (Exception e) {
            log.error("Exception in findByUserIdRepo ========= {}", e.getMessage());
            return null;
        }
    }


}

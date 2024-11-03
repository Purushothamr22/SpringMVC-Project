package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.UserLoginEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
@Slf4j

public class UserRepositoryImpl implements UserRepository {
    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public String saveUserInfo(UserRegistrationEntity userRegistrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(userRegistrationEntity);
            transaction.commit();
            return "Data Saved";
        } catch (Exception e) {
            log.error("error in saveUserInfo repo ............. " + e.getMessage());
            return "data save error";
        } finally {
            entityManager.close();
        }

    }

    @Override
    public UserRegistrationEntity findBYUserEmail(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("");
            query.setParameter("emailId", emailId);
            UserRegistrationEntity singleResult = (UserRegistrationEntity) query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            log.error("error in onFindByUserEmail repo ............. " + e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public String saveLoginInfo(UserLoginEntity userLoginEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
          EntityTransaction transaction = entityManager.getTransaction();
          transaction.begin();
          entityManager.persist(userLoginEntity);
          transaction.commit();
          return "Login Saved";
      }catch (Exception e){
          log.error("error in saveLoginInfo repo ............. " + e.getMessage());
          return "data save error";
      }finally {
          entityManager.close();
      }

    }
}

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
    private EntityManagerFactory entityManagerFactory;

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
    public UserRegistrationEntity findByUserEmail(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByUserEmail");
            query.setParameter("emailId", emailId);
            UserRegistrationEntity singleResult = (UserRegistrationEntity) query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            log.error("error in onFindByUserEmail repo ............. " + e.getMessage());

        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public String saveLoginInfo(UserLoginEntity userLoginEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
          EntityTransaction transaction = entityManager.getTransaction();
          transaction.begin();
          entityManager.merge(userLoginEntity);
          transaction.commit();
          return "Login Saved";
      }catch (Exception e){
          log.error("error in saveLoginInfo repo ............. " + e.getMessage());
          return "data save error";
      }finally {
          entityManager.close();
      }

    }

    @Override
    public boolean userBlockedByEmail(String emailId, boolean isAccountBlocked, Integer noOfAttempts) {
        log.info("userBlockedByEmail method started ===========================");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("passwordWrongAttemptByUserEmail");
            query.setParameter("emailId", emailId);
            query.setParameter("noOfAttempts", noOfAttempts);
            query.setParameter("isAccountBlocked", isAccountBlocked);
            query.executeUpdate();
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            log.error("error in  repo  userBlockedByEmail method");
            return false;
        }finally {
            entityManager.close();
        }
    }

    @Override
    public UserRegistrationEntity findUserOtpDetailsByEmail(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            Query query = entityManager.createNamedQuery("findUserOtpDetailsByEmail");
            query.setParameter("emailId",emailId);
            UserRegistrationEntity result = (UserRegistrationEntity) query.getSingleResult();
            return result;
        }catch(Exception e){
            log.error("error in  repo  findUserOtpDetailsByEmail method");
        }finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public String updateUserOtp(String emailId, String otp) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("updateUserOtp");
            transaction.begin();
            query.setParameter("emailId",emailId);
            query.setParameter("otp",otp);
            query.executeUpdate();
            transaction.commit();
            return "Otp Updated";
        }catch(Exception e){
            log.error("error in  repo  updateUserOtp method");
            return "Update Error";
        }finally {
            entityManager.close();
        }

    }

    @Override
    public UserRegistrationEntity findByMobileNo(Long mobileNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("");
            query.setParameter("mobileNumber",mobileNumber);
            return (UserRegistrationEntity) query.getSingleResult();
        }catch (Exception e){
            log.error("error in UserRepository repo findByMobileNo ============= {}",e.getMessage());
        }finally {
            entityManager.close();
        }
        return null;
    }
}

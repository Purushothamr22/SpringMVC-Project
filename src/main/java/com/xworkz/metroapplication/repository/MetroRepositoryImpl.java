package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.LoginEntity;
import com.xworkz.metroapplication.entity.RegistrationEntity;
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

public class MetroRepositoryImpl implements MetroRepository {
    @Autowired
   private EntityManagerFactory entityManagerFactory;


    @Override
    public String saveRegistrationDetails(RegistrationEntity registrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();

            entityManager.persist(registrationEntity);
            entityTransaction.commit();
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
        } finally {
            entityManager.close();
        }
        return "Save error";
    }


    @Override
    public String saveLoginDetails(LoginEntity loginEntity) {
        System.out.println(" ");
        log.info("save login details repo==================   "+loginEntity);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            entityManager.merge(loginEntity);
            entityTransaction.commit();
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            throw new RuntimeException("Error while saving login details", e);
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<RegistrationEntity> fetchAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query namedQuery = entityManager.createNamedQuery("fetchall");
            List<RegistrationEntity> resultList = (List<RegistrationEntity>) namedQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            throw new RuntimeException();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public RegistrationEntity findByName(String firstName) {
        log.info("this is on find by user name repo ");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("fetchbyname");
            query.setParameter("name", firstName);
            System.out.println("setting parameter : " + firstName);
            log.info("this is on find by user name repo  ");
            return (RegistrationEntity) query.getSingleResult();
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            System.err.println("find by name method catch block ");
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public RegistrationEntity findByEmail(String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("fetchByEmail");
            query.setParameter("emailId", emailId);
            RegistrationEntity result = (RegistrationEntity) query.getSingleResult();
            return result;
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            System.err.println("find by email method catch block ");
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public String updateOtp(String otp, String emailId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            Query query = entityManager.createNamedQuery("updateByEmail");
            transaction.begin();
            query.setParameter("emailId", emailId);
            query.setParameter("otp", otp);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            System.err.println("got error......");

        } finally {
            entityManager.close();
        }
        return "";
    }

    @Override
    public boolean updatePasswordByEmailId(String encryptedPassword, String emailId) {
        log.info("updatePasswordByEmailId method started ===========================");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            Query query = entityManager.createNamedQuery("updatePassword");
            transaction.begin();
            query.setParameter("password", encryptedPassword);
            query.setParameter("emailId", emailId);
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            log.error("got error......"+e.getMessage());
            log.error("Error in Repository updatePasswordByEmailId method");
        } finally {
            entityManager.close();
        }
        return false;
    }

    @Override
    public boolean userBlockedByEmail(String emailId, boolean isAccountBlocked, Integer noOfAttempts) {
        log.info("userBlockedByEmail method started ===========================");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("passwordWrongAttemptByEmail");
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
    public String updateUserProfile(RegistrationEntity registrationEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(registrationEntity);
            transaction.commit();
        }catch (Exception e){
            log.error("error in update profile " +e.getMessage());
        }finally {
            entityManager.close();
        }
        return "user not updated";
    }

    @Override
    public RegistrationEntity findByMobileNumber(Long mobileNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByMNumber");
            query.setParameter("mobileNumber",mobileNumber);
            RegistrationEntity queryResult = (RegistrationEntity) query.getSingleResult();
            return  queryResult;
        }catch (Exception e){
            log.error("got error in find  by mobile number......"+e.getMessage());
        }
        return null;
    }




}

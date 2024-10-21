package com.xworkz.metroapplication.repository;


import com.xworkz.metroapplication.entity.LoginEntity;
import com.xworkz.metroapplication.entity.RegistrationEntity;

import java.util.List;

public interface MetroRepository {
    String saveRegistrationDetails(RegistrationEntity registrationEntity);

    String saveLoginDetails(LoginEntity loginEntity);

    List<RegistrationEntity> fetchAll();

    RegistrationEntity findByUserName(String userName);

    RegistrationEntity findByEmail(String emailId);
    String updateOtp(String  otp,String emailId);
    boolean updatePasswordByEmailId(String encryptedPassword,String emailId);
    boolean userBlockedByEmail(String emailId, boolean isAccountBlocked, Integer noOfAttempts);
    String updateUserProfile(RegistrationEntity registrationEntity);
    RegistrationEntity findByMobileNumber(Long mobileNumber);



}

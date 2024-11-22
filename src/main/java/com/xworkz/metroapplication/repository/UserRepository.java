package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.UserLoginEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;


public interface UserRepository {

    String saveUserInfo(UserRegistrationEntity userRegistrationEntity);
    UserRegistrationEntity findByUserEmail(String emailId);

    String saveLoginInfo(UserLoginEntity userLoginEntity);
    boolean userBlockedByEmail(String emailId, boolean isAccountBlocked, Integer noOfAttempts);

    UserRegistrationEntity findUserOtpDetailsByEmail(String emailId);
    String updateUserOtp(String emailId,String otp);

    UserRegistrationEntity findByMobileNo(Long mobileNumber);
}

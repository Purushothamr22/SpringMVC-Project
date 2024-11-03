package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.UserLoginEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;


public interface UserRepository {

    String saveUserInfo(UserRegistrationEntity userRegistrationEntity);
    UserRegistrationEntity findBYUserEmail(String emailId);

    String saveLoginInfo(UserLoginEntity userLoginEntity);
}

package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.UserRegistrationDto;

public interface UserService {
    String onSaveUserInfo(UserRegistrationDto userRegistrationDto);
    UserRegistrationDto onFindByUserEmail(String  emailId);
    String onSaveLoginInfo(String emailId, String password);
}

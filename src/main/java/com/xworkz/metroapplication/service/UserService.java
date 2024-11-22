package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.UserRegistrationDto;

public interface UserService {
    String onSaveUserInfo(UserRegistrationDto userRegistrationDto);
    UserRegistrationDto onFindByUserEmail(String  emailId);
    UserRegistrationDto onFindByMobileNo(Long mobileNumber);
    String onSaveLoginInfo(String emailId, String otp);

    UserRegistrationDto getUserOtpDetails(String emailId);
    String updateUserOtp(String emailId);

    boolean verifyUserOtp(String emailId ,String otp);
}

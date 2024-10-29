package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.RegistrationDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MetroService {
    boolean onSaveRegistrationDetails(RegistrationDto registrationDto);


    String  onSaveLoginDetailsByEmail(String emailId, String password);


    List<RegistrationDto> onFetchAll();

    RegistrationDto onFindByName(String firstName);

    RegistrationDto onFindByEmailId(String emailId);

    String onUpdateByEmailId(String emailId, String otp);

    boolean verifyOtp(String emailId, String otpEntered);
    boolean onUpdatePasswordByEmailId(String password,String confirmPassword,String emailId);
    String updateProfile(RegistrationDto registrationDto);
    RegistrationDto onFindByMobileNumber(Long mobileNumber);
     boolean saveEditedProfile(RegistrationDto registrationDto, MultipartFile file);
//     String findByStationName(String fromStation,String toStation);


}

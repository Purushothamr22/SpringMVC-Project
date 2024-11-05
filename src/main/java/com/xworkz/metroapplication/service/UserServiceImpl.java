package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.UserLoginDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.entity.UserLoginEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;
import com.xworkz.metroapplication.repository.UserRepository;
import com.xworkz.metroapplication.util.EmailClass;
import com.xworkz.metroapplication.util.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@Slf4j


public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Encryption encryption;

    @Autowired
    EmailClass emailClass;
    @Override
    public String onSaveUserInfo(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto != null) {
            UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
            userRegistrationDto.setAccountBlocked(false);
            userRegistrationDto.setNoOfAttempts(0);
            userRegistrationDto.setUserImage("temp.jpg");
            userRegistrationDto.setImageType("Image/jpeg");
            userRegistrationDto.setPassword(encryption.encrypt(userRegistrationDto.getPassword()));
            BeanUtils.copyProperties(userRegistrationDto, userRegistrationEntity);
            userRepository.saveUserInfo(userRegistrationEntity);
            return "Data saved";
        }
        return "null";
    }

    @Override
    public UserRegistrationDto onFindByUserEmail(String emailId) {
        if (emailId != null) {
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            UserRegistrationEntity userRegistrationEntity = userRepository.findByUserEmail(emailId);

            if (userRegistrationEntity != null) {
                BeanUtils.copyProperties(userRegistrationEntity, userRegistrationDto);
                return userRegistrationDto;
            }
        }
        return null;
    }

    @Override
    public String onSaveLoginInfo(String emailId, String password) {

        UserRegistrationDto userRegistrationDto = onFindByUserEmail(emailId);
        String decryptedPassword = encryption.decrypt(userRegistrationDto.getPassword());
        if ((!userRegistrationDto.getEmailId().equals(emailId)) || (!password.equals(decryptedPassword))) {
            if (userRegistrationDto.getNoOfAttempts() == null) {
                userRegistrationDto.setNoOfAttempts(0);
            }
            userRegistrationDto.setNoOfAttempts(userRegistrationDto.getNoOfAttempts() + 1);
            UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
            BeanUtils.copyProperties(userRegistrationDto, userRegistrationEntity);
            userRepository.userBlockedByEmail(emailId, userRegistrationEntity.isAccountBlocked(), userRegistrationEntity.getNoOfAttempts());


            if (userRegistrationDto.getNoOfAttempts() >= 3) {
                userRegistrationDto.setAccountBlocked(true);
                BeanUtils.copyProperties(userRegistrationDto, userRegistrationEntity);

                userRepository.userBlockedByEmail(emailId, userRegistrationEntity.isAccountBlocked(), userRegistrationEntity.getNoOfAttempts());
            }
            return "Invalid Login";
        } else {

            UserLoginDto userLoginDto = new UserLoginDto();
            userLoginDto.setId(userRegistrationDto.getId());
            userLoginDto.setFirstName(userRegistrationDto.getFirstName());
            userLoginDto.setPassword(encryption.encrypt(userRegistrationDto.getPassword()));
            userLoginDto.setLoginTime(LocalDateTime.now().toString());
            userLoginDto.setLogoutTime(null);
            userLoginDto.setEmailId(userRegistrationDto.getEmailId());
            UserLoginEntity userLoginEntity = new UserLoginEntity();
            BeanUtils.copyProperties(userLoginDto, userLoginEntity);
            userRepository.saveLoginInfo(userLoginEntity);

            UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
            userRegistrationDto.setAccountBlocked(false);
            userRegistrationDto.setNoOfAttempts(0);
            BeanUtils.copyProperties(userRegistrationDto, userRegistrationEntity);
            userRepository.userBlockedByEmail(emailId, userRegistrationEntity.isAccountBlocked(), userRegistrationEntity.getNoOfAttempts());
            return "Login Successful";
        }

    }

    @Override
    public UserRegistrationDto getUserOtpDetails(String emailId) {
        if (emailId!=null){
            UserRegistrationEntity userOtpDetailsByEmail = userRepository.findUserOtpDetailsByEmail(emailId);
            updateUserOtp(emailId);
            if (userOtpDetailsByEmail != null) {
                UserRegistrationDto userRegistrationDto =new UserRegistrationDto();
                BeanUtils.copyProperties(userOtpDetailsByEmail,userRegistrationDto);
                return userRegistrationDto;
            }
        }
        return null;
    }

    @Override
    public String updateUserOtp(String emailId) {
        if (emailId != null) {
            String emailSend = emailClass.emailSend(emailId);
            String encryptedOtp = encryption.encrypt(emailSend);
            userRepository.updateUserOtp(emailId,encryptedOtp);
        }
        return "Update Error";
    }

    @Override
    public boolean verifyUserOtp(String emailId, String otp) {
        UserRegistrationDto userRegistrationDto = onFindByUserEmail(emailId);
        if (otp.equals(encryption.decrypt(userRegistrationDto.getOtp()))){
            log.info("otp is present");
            return true;
        }
        return false;
    }


}

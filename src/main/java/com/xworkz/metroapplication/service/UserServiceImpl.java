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
    private UserRepository userRepository;
    @Autowired
    private Encryption encryption;

    @Autowired
    private EmailClass emailClass;

    @Override
    public String onSaveUserInfo(UserRegistrationDto userRegistrationDto) {
        if (userRegistrationDto != null) {
            UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
            userRegistrationDto.setAccountBlocked(false);
            userRegistrationDto.setNoOfAttempts(0);
            userRegistrationDto.setUserImage("temp.jpg");
            userRegistrationDto.setImageType("Image/jpeg");
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
    public UserRegistrationDto onFindByMobileNo(Long mobileNumber) {
        if (mobileNumber != null) {
            UserRegistrationEntity byMobileNo = userRepository.findByMobileNo(mobileNumber);
            UserRegistrationDto registrationDto = new UserRegistrationDto();
            if (byMobileNo != null) {
                BeanUtils.copyProperties(byMobileNo, registrationDto);
                return registrationDto;
            }
        }
        return null;
    }

    @Override
    public String onSaveLoginInfo(String emailId, String otp) {

        if (emailId != null && otp != null) {
            UserRegistrationDto userRegistrationDto = onFindByUserEmail(emailId);
            log.info("user dto from onSaveLoginInfo is ============== "+userRegistrationDto);
            UserLoginDto userLoginDto = new UserLoginDto();
            userLoginDto.setId(userRegistrationDto.getId());
            userLoginDto.setFirstName(userRegistrationDto.getFirstName());
            userLoginDto.setLoginTime(LocalDateTime.now().toString());
            userLoginDto.setLogoutTime(null);
            userLoginDto.setEmailId(userRegistrationDto.getEmailId());
            UserLoginEntity userLoginEntity = new UserLoginEntity();
            BeanUtils.copyProperties(userLoginDto, userLoginEntity);
            userRepository.saveLoginInfo(userLoginEntity);
            return "Login Successful";
        }
        return "login save error";

    }

    @Override
    public UserRegistrationDto getUserOtpDetails(String emailId) {
        if (emailId != null) {
            UserRegistrationEntity userOtpDetailsByEmail = userRepository.findUserOtpDetailsByEmail(emailId);
            log.error("the email id of getUserOtpDetails repo is ====================== {}", emailId);
            log.error("the  entity of getUserOtpDetail repo is ====================== {}", userOtpDetailsByEmail);
            updateUserOtp(emailId);
            if (userOtpDetailsByEmail != null) {
                UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
                BeanUtils.copyProperties(userOtpDetailsByEmail, userRegistrationDto);
                log.error("the  dto of getUserOtpDetail repo is ====================== {}", userRegistrationDto);
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
            userRepository.updateUserOtp(emailId, encryptedOtp);
        }
        return "Update Error";
    }

    @Override
    public boolean verifyUserOtp(String emailId, String otp) {
        UserRegistrationDto userRegistrationDto = onFindByUserEmail(emailId);
        if (otp.equals(encryption.decrypt(userRegistrationDto.getOtp()))) {
            String onSaveLoginInfo = onSaveLoginInfo(emailId, otp);
            log.info("saving details is ===================== " + onSaveLoginInfo);
            log.info("otp is present");
            return true;
        }
        return false;
    }


}

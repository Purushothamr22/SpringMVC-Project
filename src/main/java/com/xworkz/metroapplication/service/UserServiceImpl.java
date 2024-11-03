package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.UserLoginDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.entity.UserLoginEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;
import com.xworkz.metroapplication.repository.UserRepository;
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
            UserRegistrationEntity userRegistrationEntity = userRepository.findBYUserEmail(emailId);
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            BeanUtils.copyProperties(userRegistrationEntity, userRegistrationDto);
            return userRegistrationDto;
        }
        return null;
    }

    @Override
    public String onSaveLoginInfo(String emailId, String password) {

        UserRegistrationDto userRegistrationDto = onFindByUserEmail(emailId);
        UserLoginDto userLoginDto = new UserLoginDto();
        userLoginDto.setLoginTime(LocalDateTime.now().toString());
        userLoginDto.setPassword(userRegistrationDto.getPassword());
        userLoginDto.setEmailId(userRegistrationDto.getEmailId());
        userLoginDto.setLogoutTime(null);
        userLoginDto.setFirstName(userRegistrationDto.getFirstName());
        UserLoginEntity userLoginEntity = new UserLoginEntity();
        BeanUtils.copyProperties(userLoginDto, userLoginEntity);
        userRepository.saveLoginInfo(userLoginEntity);


        return "null";
    }
}

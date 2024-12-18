package com.xworkz.metroapplication.service;


import com.xworkz.metroapplication.dto.LoginDto;
import com.xworkz.metroapplication.dto.RegistrationDto;
import com.xworkz.metroapplication.entity.LoginEntity;
import com.xworkz.metroapplication.entity.RegistrationEntity;
import com.xworkz.metroapplication.repository.MetroRepository;
import com.xworkz.metroapplication.util.EmailClass;
import com.xworkz.metroapplication.util.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
@Slf4j
public class MetroServiceImpl implements MetroService {
    @Autowired
    private MetroRepository metroRepository;
    @Autowired
    private Encryption encryption;
    @Autowired
    private EmailClass emailClass;
    private static final String UPLOADED_FOLDER = "C://Users//NEW//IdeaProjects//metro-application//fileUploadImages//";

    @Override
    public boolean onSaveRegistrationDetails(RegistrationDto registrationDto) {
        RegistrationDto registrationDto1 = onFindByEmailId(registrationDto.getEmailId());
        if (registrationDto1 == null) {
            RegistrationEntity registrationEntity = new RegistrationEntity();
            registrationDto.setPassword(encryption.encrypt(registrationDto.getPassword()));
            registrationDto.setUserImage("temp.jpg");
            registrationDto.setImageType("Image/jpg");
            log.info("B Day ===================" + registrationDto.getBirthdayDate());
            BeanUtils.copyProperties(registrationDto, registrationEntity);
            metroRepository.saveRegistrationDetails(registrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public String onSaveLoginDetailsByEmail(String emailId, String password) {
        RegistrationDto registrationDto = onFindByEmailId(emailId);
        String decryptedPassword = encryption.decrypt(registrationDto.getPassword());
        if ((!registrationDto.getEmailId().equals(emailId)) || (!password.equals(decryptedPassword))) {
            if (registrationDto.getNoOfAttempts() == null) {
                registrationDto.setNoOfAttempts(0);
            }
            registrationDto.setNoOfAttempts(registrationDto.getNoOfAttempts() + 1);
            RegistrationEntity registrationEntity = new RegistrationEntity();
            BeanUtils.copyProperties(registrationDto, registrationEntity);
            metroRepository.userBlockedByEmail(emailId, registrationEntity.isAccountBlocked(), registrationEntity.getNoOfAttempts());
            if (registrationDto.getNoOfAttempts() >= 3) {
                registrationDto.setAccountBlocked(true);
                BeanUtils.copyProperties(registrationDto, registrationEntity);
                metroRepository.userBlockedByEmail(emailId, registrationEntity.isAccountBlocked(), registrationEntity.getNoOfAttempts());
            }
            return "Invalid Login";
        } else {
            LoginDto loginDto = new LoginDto();
            loginDto.setId(registrationDto.getId());
            loginDto.setFirstName(registrationDto.getFirstName());
            loginDto.setPassword(encryption.encrypt(registrationDto.getPassword()));
            loginDto.setLoginTime(LocalDateTime.now().toString());
            loginDto.setLogoutTime(null);
            loginDto.setEmailId(registrationDto.getEmailId());
            LoginEntity loginEntity = new LoginEntity();
            BeanUtils.copyProperties(loginDto, loginEntity);
            metroRepository.saveLoginDetails(loginEntity);
            RegistrationEntity registrationEntity = new RegistrationEntity();
            registrationDto.setAccountBlocked(false);
            registrationDto.setNoOfAttempts(0);
            BeanUtils.copyProperties(registrationDto, registrationEntity);
            metroRepository.userBlockedByEmail(emailId, registrationEntity.isAccountBlocked(), registrationEntity.getNoOfAttempts());
            return "Login Successful";
        }
    }
    @Override
    public RegistrationDto onFindById(Integer id) {
        if (id != null) {
            RegistrationDto registrationDto = new RegistrationDto();
            RegistrationEntity registrationEntity = metroRepository.findById(id);
            registrationEntity.setPassword(encryption.decrypt(registrationEntity.getPassword()));
            BeanUtils.copyProperties(registrationEntity, registrationDto);
            return registrationDto;
        } else {
            System.out.println("User name is invalid or not given");
        }
        return null;
    }

    @Override
    public RegistrationDto onFindByEmailId(String emailId) {
        if (emailId != null) {
            RegistrationDto registrationDto = new RegistrationDto();
            RegistrationEntity registrationEntity = metroRepository.findByEmail(emailId);
            if (registrationEntity != null) {
                BeanUtils.copyProperties(registrationEntity, registrationDto);
                return registrationDto;
            }
        }
        return null;
    }

    @Override
    public String onUpdateByEmailId(String emailId) {

        if (emailId != null) {
            String sentEmail = emailClass.emailSend(emailId);
            String encryptedOtp = encryption.encrypt(sentEmail);
            metroRepository.updateOtp(encryptedOtp, emailId);
            return "Otp Sent Successfully";
        }
        return "Can't find email";
    }

    @Override
    public boolean verifyOtp(String emailId, String otpEntered) {
        RegistrationDto registrationDto = onFindByEmailId(emailId);
        if (registrationDto != null) {
            String decrypt = encryption.decrypt(registrationDto.getOtp());
            registrationDto.setOtp(decrypt);
            if (otpEntered.equals(registrationDto.getOtp())) {
                log.info("otp is present");
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean onUpdatePasswordByEmailId(String password, String confirmPassword, String emailId) {
        log.info("====================onUpdatePasswordByEmailId METHOD =======================");
        RegistrationDto registrationDto = onFindByEmailId(emailId);
        if (registrationDto != null) {
            if (password.equals(confirmPassword)) {
                RegistrationEntity registrationEntity = new RegistrationEntity();
                BeanUtils.copyProperties(registrationDto, registrationEntity);
                String encryptPassword = encryption.encrypt(password);
                boolean updatePasswordByEmailId = metroRepository.updatePasswordByEmailId(encryptPassword, emailId);
                log.info("Password update status :===========" + updatePasswordByEmailId);
                if (updatePasswordByEmailId) {
                    metroRepository.userBlockedByEmail(emailId, false, 0);
                }

                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public String updateProfile(RegistrationDto registrationDto) {
        if (registrationDto != null) {
            RegistrationDto registrationDto1 = onFindById(registrationDto.getId());
            RegistrationEntity registrationEntity = new RegistrationEntity();
            registrationDto1.setPassword(encryption.encrypt(registrationDto1.getPassword()));
            BeanUtils.copyProperties(registrationDto1, registrationEntity);
            metroRepository.updateUserProfile(registrationEntity);
            return "profile updated";
        }
        return "the data is null";
    }

    @Override
    public RegistrationDto onFindByMobileNumber(Long mobileNumber) {
        if (mobileNumber != null) {
            RegistrationDto registrationDto = new RegistrationDto();
            RegistrationEntity registrationEntity = metroRepository.findByMobileNumber(mobileNumber);
            if (registrationEntity != null) {
                BeanUtils.copyProperties(registrationEntity, registrationDto);
                return registrationDto;
            }
        }
        return null;
    }

    @Override
    public boolean saveEditedProfile(RegistrationDto registrationDto, MultipartFile file) {
        RegistrationDto existingDto = onFindByEmailId(registrationDto.getEmailId());
        RegistrationEntity registerEntity = new RegistrationEntity();
        if (file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                registrationDto.setUserImage(file.getOriginalFilename());
                registrationDto.setImageType(file.getContentType());
                BeanUtils.copyProperties(registrationDto, registerEntity);
                metroRepository.updateUserProfile(registerEntity);
                return true;
            } catch (IOException ignored) {
                log.info("Error in saveEditedProfile-------------------{}", ignored.getMessage());
            }
        } else {
            registrationDto.setUserImage(existingDto.getUserImage());
            registrationDto.setImageType(existingDto.getImageType());
            BeanUtils.copyProperties(registrationDto, registerEntity);
            metroRepository.updateUserProfile(registerEntity);
            return true;
        }
        return false;
    }


}


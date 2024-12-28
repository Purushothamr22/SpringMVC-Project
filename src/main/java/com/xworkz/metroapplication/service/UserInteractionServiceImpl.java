package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TicketBookingDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TicketBookingEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;
import com.xworkz.metroapplication.repository.UserInteractionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class UserInteractionServiceImpl implements UserInteractionService {
    @Autowired
    UserInteractionRepo userInteractionRepo;
    @Autowired
    UserService userService;

    private static final String UPLOADED_FOLDER = "C://Users//NEW//IdeaProjects//metro-application//UserUploadedImages";

    @Override
    public List<StationDetailsDto> onFindStationDetails() {
        List<StationDetailsEntity> stationDetails = userInteractionRepo.findStationDetails();
        List<StationDetailsDto> stationDetailsDtoList = new ArrayList<>();
        stationDetails.forEach(entity -> {
            StationDetailsDto stationDetailsDto = new StationDetailsDto();
            BeanUtils.copyProperties(entity, stationDetailsDto);
            stationDetailsDtoList.add(stationDetailsDto);
        });
        log.info("list of station in service is ===============  {}", stationDetailsDtoList);
        return stationDetailsDtoList;

    }

    @Override
    public String saveTicketDetailsService(String source, String destination, String userLoginId, String tokenNumber) {
        TrainTimeDetailsDto trainTimeDetailsDto = onFindSourceDestinationDetails(source, destination);
        TicketBookingDto ticketBookingDto = new TicketBookingDto();
        ticketBookingDto.setSource(trainTimeDetailsDto.getSource());
        ticketBookingDto.setDestination(trainTimeDetailsDto.getDestination());
        ticketBookingDto.setPrice(trainTimeDetailsDto.getPrice());
        ticketBookingDto.setSourceTime(trainTimeDetailsDto.getSourceTime());
        ticketBookingDto.setUserLoginId(Integer.valueOf(userLoginId));
        ticketBookingDto.setDestinationTime(trainTimeDetailsDto.getDestinationTime());
        ticketBookingDto.setTokenNumber(tokenNumber);
        TicketBookingEntity ticketBookingEntity = new TicketBookingEntity();
        BeanUtils.copyProperties(ticketBookingDto, ticketBookingEntity);
        return userInteractionRepo.saveTicketDetails(ticketBookingEntity);
    }


    @Override
    public UserRegistrationDto findByUserId(Integer userId) {
        if (userId != null) {
            UserRegistrationEntity entity = userInteractionRepo.findByUserIdRepo(userId);
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            BeanUtils.copyProperties(entity, userRegistrationDto);
            return userRegistrationDto;
        }
        return null;
    }

    @Override
    public TrainTimeDetailsDto onFindSourceDestinationDetails(String source, String destination) {
        TrainTimeDetailsEntity sourceDestinationDetails = userInteractionRepo.findSourceDestinationDetails(source, destination);
        TrainTimeDetailsDto detailsDto = new TrainTimeDetailsDto();
        BeanUtils.copyProperties(sourceDestinationDetails, detailsDto);
        return detailsDto;
    }

    @Override
    public boolean updateUserProfileService(UserRegistrationDto userRegistrationDto, MultipartFile file) {
        log.info("given dto from ui is ==================== {}",userRegistrationDto);
        UserRegistrationDto registrationDto = userService.onFindByUserEmail(userRegistrationDto.getEmailId());
        UserRegistrationEntity userRegistrationEntity = new UserRegistrationEntity();
        if (file != null && !file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
                registrationDto.setUserImage(file.getOriginalFilename());
                registrationDto.setImageType(file.getContentType());
                registrationDto.setFirstName(userRegistrationDto.getFirstName());
                registrationDto.setBirthdayDate(userRegistrationDto.getBirthdayDate());
                registrationDto.setGender(userRegistrationDto.getGender());
                registrationDto.setLastName(userRegistrationDto.getLastName());
                registrationDto.setMobileNumber(userRegistrationDto.getMobileNumber());
                registrationDto.setEmailId(userRegistrationDto.getEmailId());
                BeanUtils.copyProperties(registrationDto, userRegistrationEntity);
                userInteractionRepo.updateUserProfileRepo(userRegistrationEntity);
                return true;
            } catch (IOException e) {
                log.info("Error in updateUserProfileService-------------------{}", e.getMessage());
            }
        } else {
            registrationDto.setUserImage(registrationDto.getUserImage());
            registrationDto.setImageType(registrationDto.getImageType());
            registrationDto.setFirstName(userRegistrationDto.getFirstName());
            registrationDto.setBirthdayDate(userRegistrationDto.getBirthdayDate());
            registrationDto.setGender(userRegistrationDto.getGender());
            registrationDto.setLastName(userRegistrationDto.getLastName());
            registrationDto.setMobileNumber(userRegistrationDto.getMobileNumber());
            registrationDto.setEmailId(userRegistrationDto.getEmailId());
            BeanUtils.copyProperties(registrationDto, userRegistrationEntity);
            userInteractionRepo.updateUserProfileRepo(userRegistrationEntity);
            return true;
        }
        return false;
    }

    @Override
    public List<TicketBookingDto> getBookingDetails(Integer userLoginId) {
        if (userLoginId!=null) {
            List<TicketBookingEntity> bookingDetails = userInteractionRepo.getBookingDetails(userLoginId);
            List<TicketBookingDto>  ticketBookingDtoList=  bookingDetails.stream().map(ticketBookingEntity -> {
                TicketBookingDto ticketBookingDto1=new TicketBookingDto();
                BeanUtils.copyProperties(ticketBookingEntity,ticketBookingDto1);
                return ticketBookingDto1;
            }).collect(Collectors.toList());
//            log.info("ticket booking details dto is ======================   {}",ticketBookingDtoList);
          return ticketBookingDtoList;
        }
        return null;
    }

    @Override
    public TicketBookingDto getHistoryByTid(String tokenNumber){
        if (tokenNumber != null) {
            TicketBookingEntity historyByTid = userInteractionRepo.getHistoryByTid(tokenNumber);
            TicketBookingDto ticketBookingDto=new TicketBookingDto();
            BeanUtils.copyProperties(historyByTid,ticketBookingDto);
            return ticketBookingDto;
        }
        return null;
    }


}

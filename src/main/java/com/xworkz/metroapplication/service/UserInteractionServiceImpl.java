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

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class UserInteractionServiceImpl implements UserInteractionService {
    @Autowired
    UserInteractionRepo userInteractionRepo;


    @Override
    public List<StationDetailsDto> onFindStationDetails() {
        List<StationDetailsEntity> stationDetails = userInteractionRepo.findStationDetails();
        List<StationDetailsDto> stationDetailsDtoList = new ArrayList<>();
        stationDetails.stream().forEach(entity -> {
            StationDetailsDto stationDetailsDto = new StationDetailsDto();
            BeanUtils.copyProperties(entity, stationDetailsDto);
            stationDetailsDtoList.add(stationDetailsDto);
        });
        log.info("list of station in service is ===============  {}", stationDetailsDtoList);
        return stationDetailsDtoList;

    }

    @Override
    public String saveTicketDetailsService(String source, String destination, String userLoginId,String tokenNumber) {
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
    public String updatePriceService(String price, Integer trainId) {
        if (price != null&&trainId!=null) {
            String updateTicketPrice = userInteractionRepo.updateTicketPrice(price, trainId);
            log.info("Price  update status is ============= {}",updateTicketPrice);
            return updateTicketPrice;
        }
        return null;
    }

    @Override
    public UserRegistrationDto findByUserId(Integer userId) {
        if (userId != null) {
            UserRegistrationEntity entity = userInteractionRepo.findByUserIdRepo(userId);
            UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
            BeanUtils.copyProperties(entity,userRegistrationDto);
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




}

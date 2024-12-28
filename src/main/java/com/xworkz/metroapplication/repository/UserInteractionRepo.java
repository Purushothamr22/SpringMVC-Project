package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.dto.TicketBookingDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TicketBookingEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.entity.UserRegistrationEntity;

import java.util.List;

public interface UserInteractionRepo {
    TrainTimeDetailsEntity findSourceDestinationDetails(String source, String destination);
    List<StationDetailsEntity> findStationDetails();

    String saveTicketDetails(TicketBookingEntity ticketBookingEntity);

    UserRegistrationEntity findByUserIdRepo(Integer userId);
    String updateUserProfileRepo(UserRegistrationEntity userRegistrationEntity);
    List<TicketBookingEntity> getBookingDetails(Integer userLoginId);
    TicketBookingEntity getHistoryByTid(String tokenNumber);

}

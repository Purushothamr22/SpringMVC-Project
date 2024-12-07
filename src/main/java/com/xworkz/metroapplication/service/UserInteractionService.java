package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;

import java.util.List;

public interface UserInteractionService {

    TrainTimeDetailsDto onFindSourceDestinationDetails(String source, String destination);
    List<StationDetailsDto> onFindStationDetails();
    String saveTicketDetailsService(String source, String destination, String userLoginId,String tokenNumber );

    String updatePriceService(String price,Integer trainId);
    UserRegistrationDto findByUserId(Integer userId);

}

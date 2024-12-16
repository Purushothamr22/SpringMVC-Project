package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserInteractionService {

    TrainTimeDetailsDto onFindSourceDestinationDetails(String source, String destination);
    List<StationDetailsDto> onFindStationDetails();
    String saveTicketDetailsService(String source, String destination, String userLoginId,String tokenNumber );

    UserRegistrationDto findByUserId(Integer userId);
    boolean saveUserEditedProfile(UserRegistrationDto userRegistrationDto, MultipartFile file);
    List<TicketBookingDto>  getBookingDetails(Integer userLoginId);

}

package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;

import java.util.List;

public interface UserInteractionService {

    TrainTimeDetailsDto onFindSourceDestinationDetails(String source, String destination);
    List<StationDetailsDto> onFindStationDetails();
    List<TrainTimeDetailsDto> onFindAllDetails();

}

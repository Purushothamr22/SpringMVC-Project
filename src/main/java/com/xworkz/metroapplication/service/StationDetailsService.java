package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;


public interface StationDetailsService {
    String saveTrainDetails(StationDetailsDto addStationDetailsDto);
    StationDetailsDto onFindByStationNameService(String stationName);

}

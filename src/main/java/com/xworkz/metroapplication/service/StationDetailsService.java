package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;

import java.util.List;


public interface StationDetailsService {
    String saveTrainDetails(StationDetailsDto addStationDetailsDto);
    StationDetailsDto onFindByStationNameService(String stationName);
    List<StationDetailsDto> onFindAll();
}

package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;

import java.util.List;


public interface StationDetailsService {
    String saveTrainDetails(StationDetailsDto addStationDetailsDto);
    StationDetailsDto onFindByStationNameService(String stationName);
    List<StationDetailsDto> onFindAll();
    StationDetailsEntity onFindById(Integer id);
    StationDetailsDto onFindByStationId(Integer stationId);
    String updateMetroDetails(StationDetailsDto stationDetailsDto, TrainTimeDetailsDto trainTimeDetailsDto);


}

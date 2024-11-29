package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;

import java.util.List;


public interface StationDetailsService {
    String saveTrainDetails(StationDetailsDto addStationDetailsDto);
    StationDetailsDto onFindByStationNameService(String stationName);
    List<StationDetailsDto> onFindAll();
    List<StationDetailsDto> onFindAllDetails();
    StationDetailsEntity onFindById(Integer id);

}

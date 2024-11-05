package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;

import java.util.List;

public interface StationInfoRepo {
    String saveTrainDetails(StationDetailsEntity trainDetailsEntity);
    StationDetailsEntity findByStationName(String stationName);
    List<StationDetailsEntity> findAll();


}

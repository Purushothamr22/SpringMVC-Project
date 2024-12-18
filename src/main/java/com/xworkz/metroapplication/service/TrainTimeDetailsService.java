package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;

import java.util.List;

public interface TrainTimeDetailsService {
    String onSaveTimeDetails(TrainTimeDetailsDto trainTimeDetailsDto);
    TrainTimeDetailsDto onFindBySourceAndDestination(String source,String destination);
    TrainTimeDetailsDto onFindBySourceDestinationAndTimings(String source,String destination,String sourceTime,String destinationTime);
    List<TrainTimeDetailsDto> findAll();
    TrainTimeDetailsEntity onFindByTrainId(Integer trainId);
}

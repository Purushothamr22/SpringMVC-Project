package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;

import java.util.List;

public interface TrainTimeDetailsRepo {
    String saveTimeDetails(TrainTimeDetailsEntity trainTimeDetailsEntity);
    TrainTimeDetailsEntity findBySourceAndDestination(String source,String destination);
    TrainTimeDetailsEntity findBySourceDestinationAndTimings(String source,String destination,String sourceTime,String destinationTime);
    List<TrainTimeDetailsEntity> findAll();
    TrainTimeDetailsEntity findByTrainId(Integer trainId);

    String updateTimingDetails(TrainTimeDetailsEntity timeDetailsEntity);



}

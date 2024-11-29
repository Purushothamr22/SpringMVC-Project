package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;

import java.util.List;

public interface UserInteractionRepo {
    TrainTimeDetailsEntity findSourceDestinationDetails(String source, String destination);
    List<StationDetailsEntity> findStationDetails();
    List<TrainTimeDetailsEntity> findAllDetails();

}

package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;

public interface TrainTimeDetailsRepo {
    String saveTimeDetails(TrainTimeDetailsEntity trainTimeDetailsEntity);
    TrainTimeDetailsEntity findBySourceAndDestination(String source,String destination);

}

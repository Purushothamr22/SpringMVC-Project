package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;

import java.util.List;

public interface TrainTimeDetailsService {
    String onSaveTimeDetails(TrainTimeDetailsDto trainTimeDetailsDto);
    TrainTimeDetailsDto onFindBySourceAndDestination(String source,String destination);
    List<TrainTimeDetailsDto> findAll();
}

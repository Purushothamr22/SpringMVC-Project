package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class FareCalculatorImpl implements FareCalculator {
    @Autowired
    StationDetailsService stationDetailsService;

    private static final Double BASE_FARE = 10.00;
    private static final Double RATE_PER_KM = 2.00;

    @Override
    public Long calculatePrice(String source, String destination) {
        StationDetailsDto sourceDto = stationDetailsService.onFindByStationNameService(source);
        StationDetailsDto destinationDto = stationDetailsService.onFindByStationNameService(destination);
        if (sourceDto != null && destinationDto != null) {
            log.info("Source distance: {}", sourceDto.getDistance());
            log.info("Destination distance: {}", destinationDto.getDistance());
            Double distanceTravelled = Math.abs(sourceDto.getDistance() - destinationDto.getDistance());
            log.info("Distance travelled: {}", distanceTravelled);
            if (distanceTravelled <= 2) {
                log.info("Total fare: {}", BASE_FARE);
                return  Math.round(BASE_FARE);
            } else {
                double fare = BASE_FARE + (distanceTravelled * RATE_PER_KM);
                log.info("Total fare: {}", fare);
                return  Math.round(fare);
            }
        } else {
            log.error("Invalid source or destination. Source: {}, Destination: {}", source, destination);
            throw new IllegalArgumentException("Source or destination is invalid.");
        }
    }



}


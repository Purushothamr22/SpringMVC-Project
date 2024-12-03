package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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
            Double distanceTravelled = Math.abs(sourceDto.getDistance() - destinationDto.getDistance());
            if (distanceTravelled <= 2) {
                return  Math.round(BASE_FARE);
            } else {
                double fare = BASE_FARE + (distanceTravelled * RATE_PER_KM);
                return  Math.round(fare);
            }
        } else {
            log.error("Invalid source or destination. Source: {}, Destination: {}", source, destination);
            throw new IllegalArgumentException("Source or destination is invalid.");
        }
    }

    @Override
    public String generateTokenNumber() {
        StringBuilder builder =new StringBuilder();
        Random random=new Random();
        for (int i = 0; i < 6; i++) {
            builder.append(random.nextInt(10));
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dateTime = now.format(formatter);
        String uniqueID = builder.toString() + dateTime;
        log.info("Token generates is ================-------------    {}",uniqueID);
        return uniqueID;
    }


}


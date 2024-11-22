package com.xworkz.metroapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainTimeDetailsDto {
    private Integer trainId;
    private String fromDay;
    private String toDay;
    private String source;
    private String destination;
    private String trainType;
    private String sourceTime;
    private String destinationTime;
    private PriceDetailsDto priceDetails;
    private StationDetailsDto station;
}

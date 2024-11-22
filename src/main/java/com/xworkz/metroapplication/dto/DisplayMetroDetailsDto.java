package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisplayMetroDetailsDto {
    private Integer id;
    private String trainNumber;
    private String trainType;
    private String stationName;
    private String fromDay;
    private String toDay;
    private String source;
    private String destination;
    private String sourceTime;
    private String destinationTime;
    private String price;


}

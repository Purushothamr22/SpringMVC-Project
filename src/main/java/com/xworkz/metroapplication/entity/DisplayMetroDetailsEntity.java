package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Slf4j

public class DisplayMetroDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

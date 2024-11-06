package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@Slf4j
@Table(name = "TrainStation")
@NamedQuery(name = "isExistsByPrice",query = "SELECT D FROM DisplayMetroDetailsEntity D WHERE D.price =:price")
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

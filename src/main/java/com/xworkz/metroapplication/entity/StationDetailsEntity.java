package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "train_details")
@NamedQuery(name = "findByStationName", query = "SELECT A FROM StationDetailsEntity A WHERE A.stationName=:stationName ")
public class StationDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "stationName")
    private String stationName;
    @Column(name = "trainType")
    private String stationType;
    @Column(name = "trainNumber")
    private String stationNumber;
}

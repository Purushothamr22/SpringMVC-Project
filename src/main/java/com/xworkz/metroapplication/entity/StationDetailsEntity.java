package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "train_details")
@NamedQuery(name = "findAllStation", query = "SELECT A FROM StationDetailsEntity A")
@NamedQuery(name = "findByStationName", query = "SELECT A FROM StationDetailsEntity A WHERE A.stationName=:stationName ")
@NamedQuery(name = "findById" ,query = "SELECT S FROM StationDetailsEntity S WHERE S.stationId = :stationId")
public class StationDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stationId;
    @Column(name = "stationName")
    private String stationName;
    @Column(name = "trainType")
    private String stationType;
    @Column(name = "trainNumber")
    private String stationNumber;

    @OneToMany(mappedBy = "station",fetch = FetchType.EAGER)
    private List<TrainTimeDetailsEntity> trainTimeDetails;

    @Override
    public String toString() {
        return "StationDetailsEntity{" +
                "stationId=" + stationId +
                ", stationName='" + stationName + '\'' +
                ", stationType='" + stationType + '\'' +
                ", stationNumber='" + stationNumber + '\'' +
                ", trainTimeDetails=" + trainTimeDetails +
                '}';
    }
}

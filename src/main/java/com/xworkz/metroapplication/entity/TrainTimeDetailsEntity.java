package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
@Data
@NamedQuery(name = "findAllTime", query = "SELECT T FROM TrainTimeDetailsEntity T")
@NamedQuery(name = "findBySourceAndDestination", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.source=:source AND T.destination=:destination ")
@NamedQuery(name = "findByTrainId", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.trainId =:trainId")
@Table(name = "time_details")
public class TrainTimeDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String fromDay;
    private String toDay;
    private String source;
    private String destination;
    private String trainType;
    private String sourceTime;
    private String destinationTime;

    @OneToOne(mappedBy = "trainTimeDetail",fetch = FetchType.EAGER)
    private PriceDetailsEntity priceDetails;
    @ManyToOne 
    @JoinColumn(name = "stationId")
    private StationDetailsEntity station;


    @Override
    public String toString() {
        return "TrainTimeDetailsEntity{" +
                "trainId=" + trainId +
                ", fromDay='" + fromDay + '\'' +
                ", toDay='" + toDay + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", trainType='" + trainType + '\'' +
                ", sourceTime='" + sourceTime + '\'' +
                ", destinationTime='" + destinationTime + '\'' +
                ", priceDetails=" + priceDetails +
                '}';
    }
}

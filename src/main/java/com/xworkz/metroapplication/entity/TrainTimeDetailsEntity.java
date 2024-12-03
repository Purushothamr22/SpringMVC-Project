package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
@Data
@NamedQuery(name = "findAllTime", query = "SELECT T FROM TrainTimeDetailsEntity T")
@NamedQuery(name = "FindSandD", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.source=:source AND T.destination=:destination ")
@NamedQuery(name = "findBySourceAndDestination", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.source=:source AND T.destination=:destination ")
@NamedQuery(name = "findBySourceDestinationAndTimings", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.source=:source AND T.destination=:destination AND T.sourceTime=:sourceTime AND T.destinationTime=:destinationTime ")
@NamedQuery(name = "findByTrainId", query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.trainId =:trainId")
@NamedQuery(name = "updateTicketPrice",query = "UPDATE TrainTimeDetailsEntity T SET T.price=:price WHERE T.trainId=:trainId")
@Table(name = "time_details")
public class TrainTimeDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trainId;
    private String trainType;
    private String source;
    private String destination;
    private String fromDay;
    private String toDay;
    private String sourceTime;
    private String destinationTime;
    private String price;

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
                '}';
    }
}

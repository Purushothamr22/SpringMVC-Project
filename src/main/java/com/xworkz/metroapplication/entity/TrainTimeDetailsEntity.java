package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Slf4j
@Data
@NamedQuery(name = "findAllTime",query = "SELECT T FROM TrainTimeDetailsEntity T")
@NamedQuery(name = "findBySourceAndDestination",query = "SELECT T FROM TrainTimeDetailsEntity T WHERE T.source=:source AND T.destination=:destination ")
@Table(name = "time_details")
public class TrainTimeDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fromDay;
    private String toDay;
    private String source;
    private String destination;
    private String trainType;
    private String sourceTime;
    private String destinationTime;
}

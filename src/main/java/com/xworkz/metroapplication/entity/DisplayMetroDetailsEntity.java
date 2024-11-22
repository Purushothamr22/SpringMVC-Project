package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@Slf4j
@Table(name = "metro_details")
@NamedQuery(name = "isExistsByPrice",query = "SELECT D FROM DisplayMetroDetailsEntity D WHERE D.price =:price")
@NamedQuery(name = "metroList",query =  "SELECT "
        +"td.stationId AS id, "
        +"td.stationNumber AS trainNumber, "
        +"td.stationType AS trainType, "
        +"td.stationName AS stationName, "
        +"td2.fromDay AS fromDay, "
        +"td2.toDay AS toDay ,"
        +"td2.source AS source, "
        +"td2.destination AS destination ,"
        +"td2.sourceTime AS sourceTime, "
        +"td2.destinationTime AS destinationTime, "
        +"pd.price AS price "

        + "FROM StationDetailsEntity td "
        + "JOIN td.trainTimeDetails td2 "
        + "JOIN td2.priceDetails pd"
)

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

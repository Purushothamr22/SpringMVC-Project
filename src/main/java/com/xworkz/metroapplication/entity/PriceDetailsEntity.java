package com.xworkz.metroapplication.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "price_details")
@NamedQuery(name = "findPriceBySourceAndDestination",query = "SELECT P FROM PriceDetailsEntity P WHERE P.source=:source AND P.destination=:destination")
public class PriceDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String trainType;
    private String source;
    private String destination;
    private String price;
}

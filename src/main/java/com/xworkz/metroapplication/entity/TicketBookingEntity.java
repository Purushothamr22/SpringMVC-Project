package com.xworkz.metroapplication.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Data
@Slf4j
@Table(name = "Booking_details")
public class TicketBookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private Integer userLoginId;
    private String tokenNumber;
    private String source;
    private String destination;
    private String sourceTime;
    private String destinationTime;
    private String price;

}

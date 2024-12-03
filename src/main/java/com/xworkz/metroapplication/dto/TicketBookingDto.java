package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketBookingDto {

    private Integer bookingId;
    private Integer userLoginId;
    private String tokenNumber;
    private String source;
    private String destination;
    private String sourceTime;
    private String destinationTime;
    private String price;

}

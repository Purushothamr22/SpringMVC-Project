package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceDetailsDto {
    private Integer id;
    private String trainType;
    private String source;
    private String destination;
    private String price;
}

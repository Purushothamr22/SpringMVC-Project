package com.xworkz.metroapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StationDetailsDto {

    private  Integer id;
    @NotBlank
    private String stationName;
    @NotBlank
    private String stationType;
    @NotBlank
    private  String stationNumber;
}

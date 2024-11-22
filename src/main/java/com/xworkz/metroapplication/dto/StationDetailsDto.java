package com.xworkz.metroapplication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class StationDetailsDto {

    private  Integer stationId;
    @NotBlank
    private String stationName;
    @NotBlank
    private String stationType;
    @NotBlank
    private  String stationNumber;


    private List<TrainTimeDetailsDto> trainTimeDetails;


}

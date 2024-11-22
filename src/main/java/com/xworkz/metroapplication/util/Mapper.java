package com.xworkz.metroapplication.util;

import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.PriceDetailsEntity;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static PriceDetailsDto toPriceDto(PriceDetailsEntity priceDetailsEntity){
        if (priceDetailsEntity != null) {
            PriceDetailsDto priceDetailsDto=new PriceDetailsDto();
            BeanUtils.copyProperties(priceDetailsEntity,priceDetailsDto);
            return priceDetailsDto;
        }
        return null;
    }

    public static TrainTimeDetailsDto toTimeDto(TrainTimeDetailsEntity timeDetailsEntity){
        if (timeDetailsEntity != null) {
            TrainTimeDetailsDto trainTimeDetailsDto =new TrainTimeDetailsDto();
            BeanUtils.copyProperties(timeDetailsEntity,trainTimeDetailsDto);
            trainTimeDetailsDto.setPriceDetails(toPriceDto(timeDetailsEntity.getPriceDetails()));
            return trainTimeDetailsDto;
        }
        return null;
    }

    public static StationDetailsDto toStationDto(StationDetailsEntity stationDetailsEntity){

        if (stationDetailsEntity != null) {
            StationDetailsDto stationDetailsDto =new StationDetailsDto();
            BeanUtils.copyProperties(stationDetailsDto,stationDetailsEntity);
            List<TrainTimeDetailsDto> timeDetailsDtoList=new ArrayList<>();
            if (stationDetailsEntity.getTrainTimeDetails() != null) {
                for (TrainTimeDetailsEntity entity: stationDetailsEntity.getTrainTimeDetails()){
                    timeDetailsDtoList.add(toTimeDto(entity));
                }
            }
            stationDetailsDto.setTrainTimeDetails(timeDetailsDtoList);
            return stationDetailsDto;
        }
        return null;
    }


}

package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.UserInteractionRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j

public class UserInteractionServiceImpl implements UserInteractionService{
    @Autowired
    UserInteractionRepo userInteractionRepo;


    @Override
    public List<StationDetailsDto> onFindStationDetails() {
            List<StationDetailsEntity> stationDetails = userInteractionRepo.findStationDetails();
            List<StationDetailsDto> stationDetailsDtoList=new ArrayList<>();
            stationDetails.stream().forEach(entity->{
                StationDetailsDto stationDetailsDto=new StationDetailsDto();
                BeanUtils.copyProperties(entity,stationDetailsDto);
                stationDetailsDtoList.add(stationDetailsDto);
            });
        log.info("list of station in service is ===============  {}",stationDetailsDtoList);
            return stationDetailsDtoList;

    }
    @Override
    public TrainTimeDetailsDto onFindSourceDestinationDetails( String source, String destination) {
        TrainTimeDetailsEntity sourceDestinationDetails = userInteractionRepo.findSourceDestinationDetails(source, destination);
        TrainTimeDetailsDto detailsDto=new TrainTimeDetailsDto();
        BeanUtils.copyProperties(sourceDestinationDetails,detailsDto);
        return detailsDto;
    }

    @Override
    public List<TrainTimeDetailsDto> onFindAllDetails() {
        List<TrainTimeDetailsEntity> timeDetailsEntities = userInteractionRepo.findAllDetails();

        List<TrainTimeDetailsDto> trainTimeDetailsDtoList =new ArrayList<>();
        timeDetailsEntities.stream().forEach(entity->{
            TrainTimeDetailsDto trainTimeDetailsDto = new TrainTimeDetailsDto();

            BeanUtils.copyProperties(entity, trainTimeDetailsDto);

            trainTimeDetailsDtoList.add(trainTimeDetailsDto);
        });
                log.info("list of Time details entities   in service is ===============  {}", trainTimeDetailsDtoList);

        return trainTimeDetailsDtoList;

    }

}

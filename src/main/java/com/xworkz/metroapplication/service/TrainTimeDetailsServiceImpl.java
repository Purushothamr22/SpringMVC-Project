package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.TrainTimeDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j

public class TrainTimeDetailsServiceImpl implements TrainTimeDetailsService {
    @Autowired
    private TrainTimeDetailsRepo trainTimeDetailsRepo;

    @Autowired
    private StationDetailsService stationDetailsService;

    @Override
    public String onSaveTimeDetails(TrainTimeDetailsDto trainTimeDetailsDto) {
        if (trainTimeDetailsDto == null) {
            return "Data Error";
        }
        TrainTimeDetailsDto trainTimeDetailsDto1 = onFindBySourceDestinationAndTimings(trainTimeDetailsDto.getSource(), trainTimeDetailsDto.getDestination(),trainTimeDetailsDto.getSourceTime(),trainTimeDetailsDto.getDestinationTime());
        if (trainTimeDetailsDto1 == null) {
            TrainTimeDetailsEntity trainTimeDetailsEntity = new TrainTimeDetailsEntity();
            StationDetailsDto stationDetailsDto = stationDetailsService.onFindByStationNameService(trainTimeDetailsDto.getSource());
            if (stationDetailsDto != null) {
                StationDetailsEntity stationDetailsEntity = stationDetailsService.onFindById(stationDetailsDto.getStationId());
                BeanUtils.copyProperties(trainTimeDetailsDto, trainTimeDetailsEntity);
                trainTimeDetailsEntity.setStation(stationDetailsEntity);
                trainTimeDetailsEntity.setPrice(null);
                trainTimeDetailsRepo.saveTimeDetails(trainTimeDetailsEntity);
                return "Data Saved";
            }
        }
        return "Save Error";
    }


    @Override
    public TrainTimeDetailsDto onFindBySourceAndDestination(String source, String destination) {
        if (source != null && destination != null) {
            TrainTimeDetailsEntity trainTimeDetailsEntity = trainTimeDetailsRepo.findBySourceAndDestination(source, destination);
            if (trainTimeDetailsEntity != null) {
                TrainTimeDetailsDto trainTimeDetailsDto = new TrainTimeDetailsDto();
                BeanUtils.copyProperties(trainTimeDetailsEntity, trainTimeDetailsDto);
                return trainTimeDetailsDto;
            }
        }
        return null;
    }

    @Override
    public TrainTimeDetailsDto onFindBySourceDestinationAndTimings(String source, String destination, String sourceTime, String destinationTime) {
        if (source != null&& destination != null && destinationTime != null && sourceTime!=null) {
            TrainTimeDetailsEntity sourceDestinationAndTimings = trainTimeDetailsRepo.findBySourceDestinationAndTimings(source, destination, sourceTime, destinationTime);
            if (sourceDestinationAndTimings != null) {
                TrainTimeDetailsDto trainTimeDetailsDto = new TrainTimeDetailsDto();
                BeanUtils.copyProperties(sourceDestinationAndTimings, trainTimeDetailsDto);
                return trainTimeDetailsDto;
            }

        }
        return null;
    }

    @Override
    public List<TrainTimeDetailsDto> findAll() {

        List<TrainTimeDetailsEntity> timeEntityList = trainTimeDetailsRepo.findAll();
        log.info(" trainTimeDetailsRepo.onFindAll() is ============== " + timeEntityList);
        Stream<TrainTimeDetailsDto> trainTimeDetailsDtoStream = timeEntityList.stream().map(trainTimeDetailsEntity -> {
            TrainTimeDetailsDto trainTimeDetailsDto = new TrainTimeDetailsDto();
            BeanUtils.copyProperties(trainTimeDetailsEntity, trainTimeDetailsDto);
            return trainTimeDetailsDto;
        });
        return trainTimeDetailsDtoStream.collect(Collectors.toList());
    }

    @Override
    public TrainTimeDetailsEntity onFindByTrainId(Integer trainId) {
      return   trainTimeDetailsRepo.findByTrainId(trainId);
    }
}

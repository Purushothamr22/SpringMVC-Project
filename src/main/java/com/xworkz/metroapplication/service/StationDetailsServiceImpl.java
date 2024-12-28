package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.StationInfoRepo;
import com.xworkz.metroapplication.repository.TrainTimeDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class StationDetailsServiceImpl implements StationDetailsService {
    @Autowired
    private StationInfoRepo stationInfoRepo;
    @Autowired
    private TrainTimeDetailsRepo trainTimeDetailsRepo;
    private List<TrainTimeDetailsDto> trainTimeDetailsDtoList;

    @Override
    public String saveTrainDetails(StationDetailsDto addStationDetailsDto) {
        if (addStationDetailsDto == null) {
            return "save error";
        }
        StationDetailsDto findByStationNameService = onFindByStationNameService(addStationDetailsDto.getStationName());
        if (findByStationNameService != null) {
            return "save error";
        }
        StationDetailsEntity addStationDetailsEntity = new StationDetailsEntity();
        BeanUtils.copyProperties(addStationDetailsDto, addStationDetailsEntity);
        stationInfoRepo.saveTrainDetails(addStationDetailsEntity);
        return "saved Successfully";
    }

    @Override
    public StationDetailsDto onFindByStationNameService(String stationName) {
        if (stationName != null) {
            StationDetailsEntity trainDetailsEntity = stationInfoRepo.findByStationName(stationName);
            StationDetailsDto trainDetailsDto = new StationDetailsDto();
            if (trainDetailsEntity != null) {
                BeanUtils.copyProperties(trainDetailsEntity, trainDetailsDto);
                List<TrainTimeDetailsDto> trainTimeDetailsDtoList = trainDetailsEntity.getTrainTimeDetails().stream().map(trainEntity -> {
                    TrainTimeDetailsDto detailsDto = new TrainTimeDetailsDto();
                    BeanUtils.copyProperties(trainEntity, detailsDto);
                    return detailsDto;
                }).collect(Collectors.toList());
                trainDetailsDto.setTrainTimeDetails(trainTimeDetailsDtoList);
                return trainDetailsDto;
            }
        }
        return null;
    }

    @Override
    public List<StationDetailsDto> onFindAll() {
        List<StationDetailsEntity> stationEntityList = stationInfoRepo.findAll();

        List<StationDetailsDto> stationDetailsDtoList = stationEntityList.stream().map(stationDetailsEntity -> {
            StationDetailsDto stationDetailsDto = new StationDetailsDto();
            BeanUtils.copyProperties(stationDetailsEntity, stationDetailsDto);
            if (stationDetailsEntity.getTrainTimeDetails() != null) {
                List<TrainTimeDetailsDto> trainTimeDetailsDtoList = stationDetailsEntity.getTrainTimeDetails().stream().map(trainEntity -> {
                    TrainTimeDetailsDto detailsDto = new TrainTimeDetailsDto();
                    BeanUtils.copyProperties(trainEntity, detailsDto);
                    return detailsDto;
                }).collect(Collectors.toList());
                stationDetailsDto.setTrainTimeDetails(trainTimeDetailsDtoList);
            }
            return stationDetailsDto;
        }).collect(Collectors.toList());
        log.info("metro details list provided is ----------------------    {}", stationDetailsDtoList);
        return stationDetailsDtoList;

    }

    @Override
    public StationDetailsEntity onFindById(Integer id) {
        return stationInfoRepo.findById(id);
    }

    @Override
    public StationDetailsDto onFindByStationId(Integer stationId) {
        StationDetailsEntity stationDetailsEntity = onFindById(stationId);
        StationDetailsDto detailsDto=new StationDetailsDto();
        BeanUtils.copyProperties(stationDetailsEntity,detailsDto);
        return detailsDto;
    }

    @Override
    public String updateMetroDetails(StationDetailsDto stationDetailsDto, TrainTimeDetailsDto trainTimeDetailsDto) {

        if (stationDetailsDto != null&&trainTimeDetailsDto!=null) {
            stationDetailsDto.setStationName(trainTimeDetailsDto.getSource());
            stationDetailsDto.setStationType(trainTimeDetailsDto.getTrainType());
            trainTimeDetailsDto.setStation(stationDetailsDto);
            StationDetailsEntity stationDetailsEntity=new StationDetailsEntity();
            TrainTimeDetailsEntity trainTimeDetailsEntity=new TrainTimeDetailsEntity();
            BeanUtils.copyProperties(stationDetailsDto,stationDetailsEntity);
            BeanUtils.copyProperties(trainTimeDetailsDto,trainTimeDetailsEntity);
            String updateStationDetails = stationInfoRepo.updateStationDetails(stationDetailsEntity);
            String updateTimingDetails = trainTimeDetailsRepo.updateTimingDetails(trainTimeDetailsEntity);
            if (updateTimingDetails.equalsIgnoreCase( "Save success") && updateStationDetails.equalsIgnoreCase( "Save success")) {
                return "Save success";
            }
        }
        return "Save error";
    }


}

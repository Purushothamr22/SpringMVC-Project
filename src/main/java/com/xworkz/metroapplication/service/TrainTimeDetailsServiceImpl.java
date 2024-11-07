package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.TrainTimeDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class TrainTimeDetailsServiceImpl implements TrainTimeDetailsService {
    @Autowired
    TrainTimeDetailsRepo trainTimeDetailsRepo;

    @Override
    public String onSaveTimeDetails(TrainTimeDetailsDto trainTimeDetailsDto) {
        if (trainTimeDetailsDto == null) {
            return "Data Error";
        }
        log.info("the given dto to the Service is .................   " + trainTimeDetailsDto);
        TrainTimeDetailsDto trainTimeDetailsDto1 = onFindBySourceAndDestination(trainTimeDetailsDto.getSource(), trainTimeDetailsDto.getDestination());
        if (trainTimeDetailsDto1 == null) {
            TrainTimeDetailsEntity trainTimeDetailsEntity = new TrainTimeDetailsEntity();
            BeanUtils.copyProperties(trainTimeDetailsDto, trainTimeDetailsEntity);
            trainTimeDetailsRepo.saveTimeDetails(trainTimeDetailsEntity);
            return "Data Saved";
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
    public List<TrainTimeDetailsDto> findAll() {

        List<TrainTimeDetailsEntity> timeEntityList = trainTimeDetailsRepo.findAll();
        return timeEntityList.stream().map(trainTimeDetailsEntity -> {
            TrainTimeDetailsDto trainTimeDetailsDto = new TrainTimeDetailsDto();
            BeanUtils.copyProperties(trainTimeDetailsEntity, trainTimeDetailsDto);
            return trainTimeDetailsDto;
        }).collect(Collectors.toList());

    }
}

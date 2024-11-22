package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.StationInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j

public class StationDetailsServiceImpl implements StationDetailsService {
    @Autowired
    private StationInfoRepo stationInfoRepo;

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
            log.info("trainDetailsEntity for findByStationName is ============  " + trainDetailsEntity);
            StationDetailsDto trainDetailsDto = new StationDetailsDto();
            if (trainDetailsEntity != null) {
                BeanUtils.copyProperties(trainDetailsEntity, trainDetailsDto);
                log.info("trainDetailsDto for onFindByStationNameService is ============  " + trainDetailsDto);

                return trainDetailsDto;
            }
        }
        return null;
    }

    @Override
    public List<StationDetailsDto> onFindAll() {
        List<StationDetailsEntity> stationEntityList = stationInfoRepo.findAll();
        Stream<StationDetailsDto> stationDetailsDtoStream = stationEntityList.stream().map(stationDetailsEntity -> {
            StationDetailsDto stationDetailsDto = new StationDetailsDto();
            BeanUtils.copyProperties(stationDetailsEntity, stationDetailsDto);
            return stationDetailsDto;
        });
        return stationDetailsDtoStream.collect(Collectors.toList());
    }

    @Override
    public List<StationDetailsDto> onFindAllDetails() {
        List<StationDetailsEntity> entities = stationInfoRepo.findAll();
        log.info("the entity of stationInfoRepo.findAll() is =============== {}", entities);
        List<StationDetailsDto> detailsDtoList = new ArrayList<>();
        for (StationDetailsEntity entity : entities) {
            log.info("entered for loop      ========= ");
            
        }
        log.info("the dto list of stationInfoRepo.findAll() is =============== {}", detailsDtoList);
        return detailsDtoList;
    }

    @Override
    public StationDetailsEntity onFindById(Integer id) {
        return stationInfoRepo.findById(id);
    }


}

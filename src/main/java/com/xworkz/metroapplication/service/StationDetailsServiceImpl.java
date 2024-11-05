package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.repository.MetroRepository;
import com.xworkz.metroapplication.repository.StationInfoRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class StationDetailsServiceImpl implements StationDetailsService {
    @Autowired
    StationInfoRepo stationInfoRepo;

    @Override
    public String saveTrainDetails(StationDetailsDto addStationDetailsDto) {
        StationDetailsDto findByStationNameService = onFindByStationNameService(addStationDetailsDto.getStationName());
        if (addStationDetailsDto ==null ||findByStationNameService != null) {
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
                return trainDetailsDto;
            }
        }
        return null;
    }

    @Override
    public List<StationDetailsDto> onFindAll() {
        List<StationDetailsEntity> stationEntityList = stationInfoRepo.findAll();
        List<StationDetailsDto> stationDetailsDtoList = new ArrayList<>();
        if (!stationEntityList.isEmpty()){
            for (StationDetailsEntity stationDetailsEntity :stationEntityList){
                StationDetailsDto stationDetailsDto =new StationDetailsDto();
                BeanUtils.copyProperties(stationDetailsEntity,stationDetailsDto);
                stationDetailsDtoList.add(stationDetailsDto);
            }
            return stationDetailsDtoList;
        }
        return null;
    }


}

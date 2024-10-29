package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.entity.StationDetailsEntity;
import com.xworkz.metroapplication.repository.MetroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class StationDetailsServiceImpl implements StationDetailsService {
    @Autowired
    MetroRepository metroRepository;
    @Override
    public String saveTrainDetails(StationDetailsDto addStationDetailsDto) {
        StationDetailsDto findByStationNameService = onFindByStationNameService(addStationDetailsDto.getStationName());
        if (addStationDetailsDto ==null ||findByStationNameService != null) {
            return "save error";
        }
        StationDetailsEntity addStationDetailsEntity = new StationDetailsEntity();
        BeanUtils.copyProperties(addStationDetailsDto, addStationDetailsEntity);
        metroRepository.saveTrainDetails(addStationDetailsEntity);
        return "saved Successfully";
    }

    @Override
    public StationDetailsDto onFindByStationNameService(String stationName) {
        if (stationName != null) {
            StationDetailsEntity trainDetailsEntity = metroRepository.findByStationName(stationName);
            StationDetailsDto trainDetailsDto = new StationDetailsDto();
            if (trainDetailsEntity != null) {
                BeanUtils.copyProperties(trainDetailsEntity, trainDetailsDto);
                return trainDetailsDto;
            }
        }
        return null;
    }


}

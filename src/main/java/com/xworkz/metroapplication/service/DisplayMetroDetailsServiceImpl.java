package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.DisplayMetroDetailsDto;
import com.xworkz.metroapplication.entity.DisplayMetroDetailsEntity;
import com.xworkz.metroapplication.repository.DisplayDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class DisplayMetroDetailsServiceImpl implements DisplayMetroDetailsService {
    @Autowired
    private DisplayDetailsRepo displayDetailsRepo;
    @Override
    public List<DisplayMetroDetailsDto> getMetroDetails() {
        List<DisplayMetroDetailsEntity> metroDetails = displayDetailsRepo.getMetroDetails();
        List<DisplayMetroDetailsDto> metroDetailsDtoList = new ArrayList<>();
        if (metroDetails != null && !metroDetails.isEmpty()) {
            for (DisplayMetroDetailsEntity entity : metroDetails) {
                DisplayMetroDetailsDto dto = new DisplayMetroDetailsDto();
                BeanUtils.copyProperties(entity, dto);
                metroDetailsDtoList.add(dto);
            }
        }
        return metroDetailsDtoList;
    }

}

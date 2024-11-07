package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.entity.PriceDetailsEntity;
import com.xworkz.metroapplication.repository.PriceDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j

public class PriceDetailsServiceImpl implements PriceDetailsService {
    @Autowired
    PriceDetailsRepo priceDetailsRepo;
    @Autowired
    MetroService metroService;

    @Override
    public String onSavePriceDetails(PriceDetailsDto priceDetailsDto) {
        if (priceDetailsDto == null) {
            return "Data Error";
        }
        PriceDetailsDto priceDetailsDto1 = onFindPriceBySourceAndDestination(priceDetailsDto.getSource(), priceDetailsDto.getDestination());
        if (priceDetailsDto1 == null) {
            PriceDetailsEntity priceDetailsEntity = new PriceDetailsEntity();
            BeanUtils.copyProperties(priceDetailsDto, priceDetailsEntity);
            priceDetailsRepo.savePriceDetails(priceDetailsEntity);
            return "Data Saved";
        }
        return "Save Error";
    }

    @Override
    public PriceDetailsDto onFindPriceBySourceAndDestination(String source, String destination) {
        if (source != null && destination != null) {
            PriceDetailsEntity priceDetailsEntity = priceDetailsRepo.findPriceBySourceAndDestination(source, destination);
            if (priceDetailsEntity != null) {
                PriceDetailsDto priceDetailsDto = new PriceDetailsDto();
                BeanUtils.copyProperties(priceDetailsEntity, priceDetailsDto);
                return priceDetailsDto;
            }
        }
        return null;
    }

    @Override
    public List<PriceDetailsDto> onFindAll() {
        List<PriceDetailsEntity> priceDetailsEntity = priceDetailsRepo.findAll();

        return priceDetailsEntity.stream().map(priceDetailEntity -> {
            PriceDetailsDto priceDetailsDto = new PriceDetailsDto();
            BeanUtils.copyProperties(priceDetailsEntity, priceDetailsDto);
            return priceDetailsDto;
        }).collect(Collectors.toList());

    }
}

package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.entity.PriceDetailsEntity;
import com.xworkz.metroapplication.entity.TrainTimeDetailsEntity;
import com.xworkz.metroapplication.repository.PriceDetailsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j

public class PriceDetailsServiceImpl implements PriceDetailsService {
    @Autowired
    PriceDetailsRepo priceDetailsRepo;

    @Autowired
    TrainTimeDetailsService timeDetailsService;

    @Override
    public String onSavePriceDetails(PriceDetailsDto priceDetailsDto) {
        if (priceDetailsDto == null) {
            return "Data Error";
        }
        PriceDetailsDto priceDetailsDto1 = onFindPriceBySourceAndDestination(priceDetailsDto.getSource(), priceDetailsDto.getDestination());
        log.info("priceDetailsDto1 of onFindPriceBySourceAndDestination is ============  "+priceDetailsDto1);

        if (priceDetailsDto1 == null) {
            PriceDetailsEntity priceDetailsEntity = new PriceDetailsEntity();
            TrainTimeDetailsDto trainTimeDetailsDto = timeDetailsService.onFindBySourceAndDestination(priceDetailsDto.getSource(), priceDetailsDto.getDestination());
            log.info("trainTimeDetailsDto of timeDetailsService.onFindBySourceAndDestination is ============  "+trainTimeDetailsDto);
            if (trainTimeDetailsDto != null) {
                TrainTimeDetailsEntity trainTimeDetailsEntity = timeDetailsService.onFindByTrainId(trainTimeDetailsDto.getTrainId());
                BeanUtils.copyProperties(priceDetailsDto, priceDetailsEntity);
                priceDetailsEntity.setTrainTimeDetail(trainTimeDetailsEntity);
                priceDetailsRepo.savePriceDetails(priceDetailsEntity);
                return "Data Saved";
            }

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
        Stream<PriceDetailsDto> priceDetailsDtoStream = priceDetailsEntity.stream().map(priceDetailEntity -> {
            PriceDetailsDto priceDetailsDto = new PriceDetailsDto();
            BeanUtils.copyProperties(priceDetailEntity, priceDetailsDto);
            return priceDetailsDto;
        });
        List<PriceDetailsDto> collect = priceDetailsDtoStream.collect(Collectors.toList());
        log.info("price details is ========== " + collect);
        return collect;

    }
}

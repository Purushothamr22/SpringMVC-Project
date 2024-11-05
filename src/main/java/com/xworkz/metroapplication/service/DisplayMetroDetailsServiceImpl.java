package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.DisplayMetroDetailsDto;
import com.xworkz.metroapplication.dto.PriceDetailsDto;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j

public class DisplayMetroDetailsServiceImpl implements DisplayMetroDetailsService {
    @Autowired
    private PriceDetailsService priceDetailsService;

    @Autowired
    private StationDetailsService stationDetailsService;
    @Autowired
    private TrainTimeDetailsService timeDetailsService;

    @Override
    public List<DisplayMetroDetailsDto> getMetroDetails() {

        List<DisplayMetroDetailsDto> metroDetailsDtos =new ArrayList<>();

        List<PriceDetailsDto> priceDetails = priceDetailsService.onFindAll();
        List<StationDetailsDto> stationDetails = stationDetailsService.onFindAll();
        List<TrainTimeDetailsDto> timeDetails = timeDetailsService.findAll();

        for (StationDetailsDto stationDetail : stationDetails) {
            for (TrainTimeDetailsDto trainTimeDetails : timeDetails) {
                log.info("entered for each loop");
                log.info("dtos in loop are================== "+stationDetail);
                log.info("time dtos in loop are ==================== "+trainTimeDetails);
                if (equalsIgnoreCaseAndSpaces(trainTimeDetails.getSource(), stationDetail.getStationName()))  {
                    log.info("entered for each loop if condition");
                    DisplayMetroDetailsDto displayDto = new DisplayMetroDetailsDto();

                    displayDto.setTrainType(stationDetail.getStationType());
                    displayDto.setStationName(stationDetail.getStationName());


                    displayDto.setSource(trainTimeDetails.getSource());
                    displayDto.setDestination(trainTimeDetails.getDestination());
                    displayDto.setFromDay(trainTimeDetails.getFromDay());
                    displayDto.setToDay(trainTimeDetails.getToDay());
                    displayDto.setSourceTime(trainTimeDetails.getSourceTime());
                    displayDto.setDestinationTime(trainTimeDetails.getDestinationTime());

                    PriceDetailsDto matchingPrice = null;
                    for (PriceDetailsDto price : priceDetails) {
                        if (price.getTrainType().equalsIgnoreCase(trainTimeDetails.getTrainType())
                                && price.getSource().equalsIgnoreCase(trainTimeDetails.getSource())
                                && price.getDestination().equalsIgnoreCase(trainTimeDetails.getDestination())) {
                            matchingPrice = price;
                            break;
                        }
                    }

                    log.info("entered for each loop if condition check price================== " + matchingPrice);

                    if (matchingPrice != null) {
                        displayDto.setPrice(matchingPrice.getPrice());
                    }
                    metroDetailsDtos.add(displayDto);

                }


            }
        }
        log.info("the list of dtos are ================= "+metroDetailsDtos);
        return metroDetailsDtos;
    }
    public boolean equalsIgnoreCaseAndSpaces(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.replace(" ", "").equalsIgnoreCase(str2.replace(" ", ""));
    }

}

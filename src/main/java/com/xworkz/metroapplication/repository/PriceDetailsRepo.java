package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.PriceDetailsEntity;

public interface PriceDetailsRepo {
    String savePriceDetails(PriceDetailsEntity trainPriceDetailsEntity);
    PriceDetailsEntity findPriceBySourceAndDestination(String source,String destination);

}
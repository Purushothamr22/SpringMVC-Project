package com.xworkz.metroapplication.repository;

import com.xworkz.metroapplication.entity.PriceDetailsEntity;

import java.util.List;

public interface PriceDetailsRepo {
    String savePriceDetails(PriceDetailsEntity trainPriceDetailsEntity);
    PriceDetailsEntity findPriceBySourceAndDestination(String source,String destination);
    List<PriceDetailsEntity> findAll();


}
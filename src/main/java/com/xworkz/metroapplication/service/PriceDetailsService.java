package com.xworkz.metroapplication.service;

import com.xworkz.metroapplication.dto.PriceDetailsDto;

public interface PriceDetailsService {
    String onSavePriceDetails(PriceDetailsDto priceDetailsDto );
    PriceDetailsDto onFindPriceBySourceAndDestination(String source,String destination);
}

package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.service.FareCalculator;
import com.xworkz.metroapplication.service.UserInteractionService;
import com.xworkz.metroapplication.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class UserInteractionController {

    @Autowired
    UserInteractionService userInteractionService;
    @Autowired
    FareCalculator fareCalculator;

    @GetMapping("/isPriceExists")
    public ResponseEntity<String> isPriceExists(@RequestParam String source,@RequestParam String destination, Model model){
        if (source != null&&destination!=null) {
            log.info("source is ======================= {}",source);
            log.info("destination is ======================= {}",destination);
            TrainTimeDetailsDto sourceDestinationDetails =  userInteractionService.onFindSourceDestinationDetails(source, destination);
            Long calculatePrice = fareCalculator.calculatePrice(source, destination);
            model.addAttribute("trainTimeInfo",sourceDestinationDetails);
            if (calculatePrice!=null){
                log.info("price obtained is ==================== {} ",calculatePrice);
                model.addAttribute("calculatePrice",calculatePrice);
                return ResponseEntity.ok(String.valueOf(calculatePrice));
            }
        }
        return ResponseEntity.ok("Price Not Found");
    }


}

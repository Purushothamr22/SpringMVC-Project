package com.xworkz.metroapplication.controller;

import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.service.FareCalculator;
import com.xworkz.metroapplication.service.UserInteractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            TrainTimeDetailsDto sourceDestinationDetails =  userInteractionService.onFindSourceDestinationDetails(source, destination);
            Long calculatePrice = fareCalculator.calculatePrice(source, destination);
            userInteractionService.updatePriceService(String.valueOf(calculatePrice),sourceDestinationDetails.getTrainId());
            model.addAttribute("trainTimeInfo",sourceDestinationDetails);
            if (calculatePrice!=null){
                model.addAttribute("calculatePrice",calculatePrice);
                return ResponseEntity.ok(String.valueOf(calculatePrice));
            }
        }
        return ResponseEntity.ok("Price Not Found");
    }


    @GetMapping("/generateToken")
    public ResponseEntity<String> generateToken(){
        String generateTokenNumber = fareCalculator.generateTokenNumber();
        if (generateTokenNumber != null) {
            return ResponseEntity.ok(generateTokenNumber);
        }
        return ResponseEntity.ok("token Not generated");
    }

    @PostMapping("/saveTicketDetails")
    public ResponseEntity<String> saveTicketDetails(@RequestParam String source,@RequestParam String destination,@RequestParam String userLoginId,@RequestParam String tokenNumber, Model model){
        if (source != null&&destination!=null&&userLoginId!=null) {
            String ticketDetailsService = userInteractionService.saveTicketDetailsService(source, destination, userLoginId,tokenNumber );
            if (ticketDetailsService!=null){
                return ResponseEntity.ok("Token  Generated ");
            }
        }
        return ResponseEntity.ok("Token Not Generated ");
    }
}

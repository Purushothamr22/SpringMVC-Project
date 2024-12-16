package com.xworkz.metroapplication.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xworkz.metroapplication.dto.StationDetailsDto;
import com.xworkz.metroapplication.dto.TicketBookingDto;
import com.xworkz.metroapplication.dto.TrainTimeDetailsDto;
import com.xworkz.metroapplication.dto.UserRegistrationDto;
import com.xworkz.metroapplication.service.FareCalculator;
import com.xworkz.metroapplication.service.UserInteractionService;
import com.xworkz.metroapplication.service.UserService;
import com.xworkz.metroapplication.util.EmailClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    EmailClass emailClass;
    @Autowired
    UserService userService;
    @Autowired
    FareCalculator fareCalculator;

    @GetMapping("/getBookingPage")
    public String getBookingPage(String emailId, Model model) {
        log.info("Email sent is ================ {}",emailId);
        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
        log.info("Dto is ================ {}",userRegistrationDto);
        List<StationDetailsDto> stationDetailsDtoList = userInteractionService.onFindStationDetails();
        model.addAttribute("stationDetailsDtoList", stationDetailsDtoList);
        model.addAttribute("verifyUserOtpDto", userRegistrationDto);
        return "UserBooking";

    }

    @GetMapping("/isPriceExists")
    public ResponseEntity<String> isPriceExists(@RequestParam String source, @RequestParam String destination, Model model) {
        if (source != null && destination != null) {
            TrainTimeDetailsDto sourceDestinationDetails = userInteractionService.onFindSourceDestinationDetails(source, destination);
            String calculatePrice = sourceDestinationDetails.getPrice();
            model.addAttribute("trainTimeInfo", sourceDestinationDetails);
            if (calculatePrice != null) {
                model.addAttribute("calculatePrice", calculatePrice);
                return ResponseEntity.ok(calculatePrice);
            }
        }
        return ResponseEntity.ok("Price Not Found");
    }


    @GetMapping("/generateToken")
    public ResponseEntity<String> generateToken(Model model) {
        String generateTokenNumber = fareCalculator.generateTokenNumber();
        if (generateTokenNumber != null) {
            model.addAttribute("TicketMsg","Ticket Booking Successful . Have a Safe Journey");
            return ResponseEntity.ok(generateTokenNumber);
        }
        return ResponseEntity.ok("token Not generated");
    }

    @PostMapping("/saveTicketDetails")
    public ResponseEntity<String> saveTicketDetails(@RequestParam String source, @RequestParam String destination, @RequestParam String userLoginId, @RequestParam String tokenNumber, Model model) {
        if (source != null && destination != null && userLoginId != null) {
            UserRegistrationDto dto = userInteractionService.findByUserId(Integer.valueOf(userLoginId));
            String ticketDetailsService = userInteractionService.saveTicketDetailsService(source, destination, userLoginId, tokenNumber);
            if (ticketDetailsService.equalsIgnoreCase("Save Success")) {
                String bookingEmail = emailClass.sendTicketBookingEmail(dto.getEmailId(), dto.getFirstName(), tokenNumber);
                return ResponseEntity.ok("Token  Generated ");
            }
        }
        return ResponseEntity.ok("Token Not Generated ");
    }


    @GetMapping("/viewBookingHistory")
    public String viewBookingHistory(@RequestParam String userLoginId, Model model) {
        if (userLoginId != null) {

            UserRegistrationDto userRegistrationDto = userInteractionService.findByUserId(Integer.valueOf(userLoginId));
            List<TicketBookingDto> bookingDetails = userInteractionService.getBookingDetails(Integer.valueOf(userLoginId));
            if (bookingDetails != null) {
                model.addAttribute("bookingList", bookingDetails);
                model.addAttribute("verifyUserOtpDto", userRegistrationDto);
                return "BookingHistory";
            }
        }
        return "BookingHistory";
    }


//    @GetMapping("/editUserProfile")
//    public String getEditProfile(@RequestParam String emailId, Model model) {
//        UserRegistrationDto userRegistrationDto = userService.onFindByUserEmail(emailId);
//        model.addAttribute("userDto", userRegistrationDto);
//        return "ProfileUserUpdate";
//    }
}

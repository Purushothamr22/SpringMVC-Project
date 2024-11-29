package com.xworkz.metroapplication.util;

import com.xworkz.metroapplication.repository.MetroRepository;
import com.xworkz.metroapplication.util.Encryption;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service

public class EmailClass {



    @Autowired
    private JavaMailSender mailSender;

    public String getOtp(){
        Random random = new Random();
        int randomNum =100000+ random.nextInt(99999);
        return String.format("%6d", randomNum);
    }


    public String emailSend(String emailId){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("purushothamr22.xworkz@gmail.com");
        simpleMailMessage.setTo(emailId);
        simpleMailMessage.setSubject("reset Password Otp");
        String otp = getOtp();
        log.error("otp from email class"+otp);
        simpleMailMessage.setText(otp);
        mailSender.send(simpleMailMessage);
        return otp;
 }
}
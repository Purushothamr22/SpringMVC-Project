package com.xworkz.metroapplication.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Slf4j
@Service

public class EmailClass {


    @Autowired
    private JavaMailSender mailSender;

    public String getOtp() {
        Random random = new Random();
        int randomNum = 100000 + random.nextInt(99999);
        return String.format("%6d", randomNum);
    }


    public String emailSend(String emailId) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("purushothamr22.xworkz@gmail.com");
        simpleMailMessage.setTo(emailId);
        simpleMailMessage.setSubject("reset Password Otp");
        String otp = getOtp();
        log.error("otp from email class" + otp);
        simpleMailMessage.setText(otp);
        mailSender.send(simpleMailMessage);
        return otp;
    }

    public String sendRegistrationEmail(String emailId, String firstName)  {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom("purushothamr22.xworkz@gmail.com");
            helper.setTo(emailId);
            helper.setSubject("Registration Success");
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);
            String htmlContent = "<h1>Congratulations Mr. " + firstName + "!</h1>"
                    + "<p>Your Account has been <strong>Successfully registered</strong> in Namma Metro.</p>"
                    + "<p>Registered Email ID: <strong>" + emailId + "</strong></p>"
                    + "<p>Date of Registration: <strong>" + formattedDateTime + "</strong></p>";
            helper.setText(htmlContent, true);
            mailSender.send(mimeMailMessage);
            return "Email sent successfully with HTML";
        }catch (MessagingException message){
            log.error("exception in  sendRegistrationEmail =============== {}",message.getMessage());
            return "Email sending failed";
        }
    }
}
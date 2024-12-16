package com.xworkz.metroapplication.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
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
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom("purushothamr22.xworkz@gmail.com");
            helper.setTo(emailId);
            helper.setSubject("Registration Success");
            String otp = getOtp();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);
            String content = " <p>Your Account Login  has been started  </p>"
                    + " <p>Please <strong> Do Not Share <strong>this e-mail with <strong>OTP<strong>  </p>"
                    + "<p>Registered Email ID: <strong>" + emailId + "</strong></p>"
                    + "<p>Date of Registration: <strong>" + formattedDateTime + "</strong></p>"
                    +"<br>"
                    + "<p><strong> OTP <strong> For logging  your account is :---<strong> "
                    + otp + "<strong>";
            helper.setText(content, true);
            mailSender.send(mimeMailMessage);
            return otp;
        } catch (MessagingException message) {
            log.error("exception in  sendRegistrationEmail =============== {}", message.getMessage());
            return "Email sending failed";
        }
    }

    public String sendRegistrationEmail(String emailId, String firstName) {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom("purushothamr22.xworkz@gmail.com");
            helper.setTo(emailId);
            helper.setSubject("Registration Success");
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);
            String content = "<h1>Congratulations Mr. " + firstName + "!</h1>"
                    + "<p>Your Account has been <strong>Successfully registered</strong> in Namma Metro.</p>"
                    + "<p>Registered Email ID: <strong>" + emailId + "</strong></p>"
                    + "<p>Date of Registration: <strong>" + formattedDateTime + "</strong></p>";
            helper.setText(content, true);
            mailSender.send(mimeMailMessage);
            return "Email sent successfully ";
        } catch (MessagingException message) {
            log.error("exception in  sendRegistrationEmail =============== {}", message.getMessage());
            return "Email sending failed";
        }


    }

    public String sendTicketBookingEmail(String emailId, String firstName, String tokenNumber) {
        try {
            MimeMessage mimeMailMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, true);
            helper.setFrom("purushothamr22.xworkz@gmail.com");
            helper.setTo(emailId);
            helper.setSubject("Ticket Booking Request Received");

            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);

            String content = "<h1>Hello " + firstName + ",</h1>"
                    + "<p>Thank you for your ticket booking request!</p>"
                    + "<p>Here are the details of your request:</p>"
                    + "<ul>"
                    + "    <li><strong>Token Number:</strong> " + tokenNumber + "</li>"
                    + "    <li><strong>Registered Email ID:</strong> " + emailId + "</li>"
                    + "    <li><strong>Date and Time of Request:</strong> " + formattedDateTime + "</li>"
                    + "</ul>"
                    + "<p>We are processing your request and will get back to you soon with confirmation.</p>"
                    + "<p>If you have any questions, feel free to reach out to our support team.</p>"
                    + "<br>"
                    + "<p>Thank you,</p>"
                    + "<p><strong>Ticketing Team</strong></p>";

            helper.setText(content, true);
            mailSender.send(mimeMailMessage);
            return "Email sent successfully";
        } catch (MessagingException message) {
            log.error("Exception in sendTicketBookingEmail =============== {}", message.getMessage());
            return "Email sending failed";
        }
    }
}

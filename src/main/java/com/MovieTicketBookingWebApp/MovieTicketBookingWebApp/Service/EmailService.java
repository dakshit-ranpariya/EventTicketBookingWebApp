package com.MovieTicketBookingWebApp.MovieTicketBookingWebApp.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    public static JavaMailSender javaMailSender;

    public static void sendOtpEmail(String email, String otp) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(email);
            helper.setSubject("OTP Verification");

            StringBuilder Body = new StringBuilder();
            Body.append("Login otp : ");
            Body.append(otp);
            helper.setText(Body.toString(),true);
            javaMailSender.send(message);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }
}


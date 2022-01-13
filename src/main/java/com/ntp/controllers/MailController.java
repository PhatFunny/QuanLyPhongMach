/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.controllers;

import com.ntp.configs.WebApplicationContextConfig.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Phat Nguyen
 */
@Controller
public class MailController {
    @Autowired
    public JavaMailSender emailSender;

    @GetMapping("/guimail")
    public String sendSimpleEmail() {

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();
        
        //Cần gủi lịch hẹn
        message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("Hen lich kham benh tai phong kham MEDICAL");
        message.setText("Benh nhan da dat lich moi den kham tai phong kham vao luc ");

        // Send Message!
        this.emailSender.send(message);

        return "guimail";
    }
}

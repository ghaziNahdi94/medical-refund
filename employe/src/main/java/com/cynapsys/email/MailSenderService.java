package com.cynapsys.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("employe")
@RestController
@CrossOrigin("*")
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    // Use it to send Simple text emails
    @RequestMapping("/sendmail/{email}")
    public void sendSimpleMail(@PathVariable String email) {
        SimpleMail mail =  new SimpleMail(email);
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail.getTo());
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());

        mailSender.send(message);
    }
}
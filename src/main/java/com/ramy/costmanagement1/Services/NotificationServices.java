package com.ramy.costmanagement1.Services;

import com.ramy.costmanagement1.Entity.Notification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationServices {
    
    private final JavaMailSender  mailSender;
    
    public NotificationServices(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public ResponseEntity<String> getNotification(Notification notification) {
        
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            
            message.setFrom("ramy.hany.attia@gmail.com");
            message.setTo(notification.getClientEmail());
            message.setSubject("Cost Management app");
            message.setText(String.format("Your invoice with id = %d, has date = %s",notification.getInvoiceId(),
                    notification.getDueDate()));
            mailSender.send(message);
            return new ResponseEntity<>("Notification sent", HttpStatus.CREATED);
        }
    catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
    }
    
    }
}

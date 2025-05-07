package com.ramy.costmanagement1.Controller;

import com.ramy.costmanagement1.Entity.Notification;
import com.ramy.costmanagement1.Services.NotificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    
    @Autowired
    NotificationServices notificationServices;
    @GetMapping
    public ResponseEntity< String> getNotification(@RequestBody Notification notification){
        return notificationServices.getNotification( notification);
    }
    
}

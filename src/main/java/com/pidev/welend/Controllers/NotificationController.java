package com.pidev.welend.Controllers;

import com.pidev.welend.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/Notification")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/getAllNotificationByAccount/{accountID}")
    public void findAllByAccount(@PathVariable("accountID") Integer accountID){
        notificationService.findAllByAccount(accountID);
    }

}

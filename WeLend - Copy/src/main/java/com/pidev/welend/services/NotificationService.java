package com.pidev.welend.services;


import com.pidev.welend.entities.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAllByAccount(Integer accountID);
    Notification createInsurancePaymenSettledtNotification(Integer accountID);

    Notification createInsurancePaymenNotFullySettledtNotification(Integer accountID);

    Notification createInsuranceRenewtNotification(Integer accountID);
}

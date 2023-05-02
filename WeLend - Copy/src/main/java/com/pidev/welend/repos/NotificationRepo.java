package com.pidev.welend.repos;

import com.pidev.welend.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepo extends JpaRepository<Notification,Integer> {
    List<Notification> findAllByAccount_AccountID(Integer accountID);
}

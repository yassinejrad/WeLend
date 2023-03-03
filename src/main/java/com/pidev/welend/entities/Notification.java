package com.pidev.welend.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notificationID")
    private Integer notificationID;
    private  String notificationContent;
    private Date notificationDate;
    @Enumerated(EnumType.STRING)
    private notificationType notificationType;
    @ManyToOne Account account;
}

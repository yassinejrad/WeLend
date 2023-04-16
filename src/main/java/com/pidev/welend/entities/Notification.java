package com.pidev.welend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	public Integer getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(Integer notificationID) {
		this.notificationID = notificationID;
	}
	public String getNotificationContent() {
		return notificationContent;
	}
	public void setNotificationContent(String notificationContent) {
		this.notificationContent = notificationContent;
	}
	public Date getNotificationDate() {
		return notificationDate;
	}
	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}
	public notificationType getNotificationType() {
		return notificationType;
	}
	public void setNotificationType(notificationType notificationType) {
		this.notificationType = notificationType;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
    
    
}

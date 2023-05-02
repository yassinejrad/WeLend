package com.pidev.welend.services;

import com.pidev.welend.entities.*;
import com.pidev.welend.repos.AccountRepo;
import com.pidev.welend.repos.InsuranceRepo;
import com.pidev.welend.repos.InsuranceTransactionRepo;
import com.pidev.welend.repos.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImp implements NotificationService {
    @Autowired
    NotificationRepo notificationRepo;
    @Autowired
    AccountRepo accountRepo;
    @Autowired
    InsuranceRepo insuranceRepo;
    @Autowired
    InsuranceTransactionRepo insuranceTransactionRepo;
    @Autowired
    EmailSenderService emailSenderService;

    @Override
    public List<Notification> findAllByAccount(Integer accountID){
        return notificationRepo.findAllByAccount_AccountID(accountID);
    }
    public static Date convertLocalDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    public static boolean sameMonthAndYear(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        int month1 = cal1.get(Calendar.MONTH);
        int year1 = cal1.get(Calendar.YEAR);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int month2 = cal2.get(Calendar.MONTH);
        int year2 = cal2.get(Calendar.YEAR);

        return (month1 == month2 && year1 == year2);
    }
    public Notification createDueInsurancePaymentNotification(Integer accountID){

        Notification notification = new Notification();
        Account account = accountRepo.findById(accountID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        notification.setAccount(account);
        notification.setNotificationDate(currentDate);
        notification.setNotificationType(notificationType.INSURANCE);
        notification.setNotificationContent("This an Insurance Payment Notification, you have to settle your payment before two days from now and thank you!");
        emailSenderService.sendEmail(account.getClient().getEmail(),"Insurance Payment Reminder",notification.getNotificationContent());
        return notificationRepo.save(notification);
    }
    @Override
    public Notification createInsurancePaymenSettledtNotification(Integer accountID){

        Notification notification = new Notification();
        Account account = accountRepo.findById(accountID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(currentDate);
        notification.setAccount(account);
        notification.setNotificationDate(currentDate);
        notification.setNotificationType(notificationType.INSURANCE);
        notification.setNotificationContent("This an Insurance Payment Notification," +
                "thank you for paying your insurance For the month of "+ cal1.get(Calendar.MONTH)+"/"+cal1.get(Calendar.YEAR));
        emailSenderService.sendEmail(account.getClient().getEmail(),"Insurance Payment Settled",notification.getNotificationContent());
        return notificationRepo.save(notification);
    }
    @Override
    public Notification createInsurancePaymenNotFullySettledtNotification(Integer accountID){

        Notification notification = new Notification();
        Account account = accountRepo.findById(accountID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(currentDate);
        notification.setAccount(account);
        notification.setNotificationDate(currentDate);
        notification.setNotificationType(notificationType.INSURANCE);
        notification.setNotificationContent("This an Insurance Payment Notification," +
                "Please proceed with paying the remaining amount as soon as possible of insurance For the month of "+ cal1.get(Calendar.MONTH)+"/"+cal1.get(Calendar.YEAR));
        emailSenderService.sendEmail(account.getClient().getEmail(),"Insurance Payment Not Fully Settled",notification.getNotificationContent());
        return notificationRepo.save(notification);
    }
    @Override
    public Notification createInsuranceRenewtNotification(Integer accountID){

        Notification notification = new Notification();
        Account account = accountRepo.findById(accountID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(currentDate);
        notification.setAccount(account);
        notification.setNotificationDate(currentDate);
        notification.setNotificationType(notificationType.INSURANCE);
        notification.setNotificationContent("This an Insurance Notification," +
                "Thank You For Renewing your insurance");
        emailSenderService.sendEmail(account.getClient().getEmail(),"Insurance Renewal",notification.getNotificationContent());
        return notificationRepo.save(notification);
    }
    @Scheduled(cron = "0 0 0 15 * *")
    public void sendInsurancePaymentNotification(){
        List<Account> accounts = accountRepo.findAll();
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        for (Account account: accounts) {
            List<insurance> insurances = insuranceRepo.findAllByAccount_AccountID(account.getAccountID());
            for (insurance insurance :insurances){
                List<insuranceTransaction>insuranceTransactions= insuranceTransactionRepo.findAllByInsurance_InsuranceID(insurance.getInsuranceID());
                for (insuranceTransaction insuranceTransaction: insuranceTransactions){
                    if (insuranceTransaction.getInsuranceTransactionStatus()==insuranceTransactionStatus.PENDING && sameMonthAndYear(insuranceTransaction.getInsuranceTransactionDate(),currentDate)){
                        createDueInsurancePaymentNotification(account.getAccountID());
                    }
                }
            }
        }
    }
    public Notification createInsuranceExpiringSoonNotification(Integer accountID){

        Notification notification = new Notification();
        Account account = accountRepo.findById(accountID).orElse(null);
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(currentDate);
        notification.setAccount(account);
        notification.setNotificationDate(currentDate);
        notification.setNotificationType(notificationType.INSURANCE);
        notification.setNotificationContent("This an Insurance Notification," +
                "Your insurance will expire soon," +
                "Please Proceed by renewing it");
        emailSenderService.sendEmail(account.getClient().getEmail(),"Your insurance will expire soon",notification.getNotificationContent());
        return notificationRepo.save(notification);
    }
    @Scheduled(cron = "0 0 0 15 * *")
    public void sendInsuranceExpiringSoon(){
        List<Account> accounts = accountRepo.findAll();
        Date currentDate = convertLocalDateToDate(LocalDate.now());
        for (Account account: accounts) {
            List<insurance> insurances = insuranceRepo.findAllByAccount_AccountID(account.getAccountID());
            for (insurance insurance :insurances){
                if (sameMonthAndYear(currentDate,insurance.getEndDate())){
                    createInsuranceExpiringSoonNotification(account.getAccountID());
                }
            }
        }
    }

}

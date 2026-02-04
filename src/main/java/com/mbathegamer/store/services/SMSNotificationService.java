package com.mbathegamer.store.services;

import org.springframework.stereotype.Service;

@Service("sms-notification")
public class SMSNotificationService implements NotificationService {
  @Override
  public void send(String message, String recipientNumber) {
    System.out.println("Recipient: " + recipientNumber);
    System.out.println("Message: " + message);
  }
}

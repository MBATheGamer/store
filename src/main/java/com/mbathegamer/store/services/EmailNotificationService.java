package com.mbathegamer.store.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service("email-notification")
public class EmailNotificationService implements NotificationService {
  @Value("${mail.host}")
  private String host;

  @Value("${mail.port}")
  private int port;

  @Override
  public void send(String message, String recipientEmail) {
    System.out.println("Recipient: " + recipientEmail);
    System.out.println("Message: " + message);
    System.out.printf("Host: %s:%d\n", host, port);
  }
}

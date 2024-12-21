package com.consultationappointment.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.consultationappointment.dto.NotificationRequest;
import com.consultationappointment.dto.NotificationResponse;
import com.consultationappointment.entity.Notification;
import com.consultationappointment.repo.NotificationRepository;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public NotificationResponse sendNotification(NotificationRequest request) {
        // Logic for sending notifications based on the channel
        boolean isSent = false;

        switch (request.getChannel().toUpperCase()) {
            case "EMAIL":
                isSent = sendEmail(request.getUserId(), request.getMessage());
                break;
            case "SMS":
                isSent = sendSms(request.getUserId(), request.getMessage());
                break;
            case "PUSH":
                isSent = sendPushNotification(request.getUserId(), request.getMessage());
                break;
            default:
                return new NotificationResponse();
        }

        // Persist notification details if required
        if (isSent) {
            Notification notification = new Notification();
            notification.setUserId(request.getUserId());
            notification.setChannel(request.getChannel());
            notification.setMessage(request.getMessage());
            notification.setSentAt(LocalDateTime.now());
            notificationRepository.save(notification);

            return new NotificationResponse();
        } else {
            return new NotificationResponse();
        }
    }

    private boolean sendEmail(Long userId, String message) {
        // Mock implementation for sending email
        System.out.println("Sending EMAIL to userId " + userId + ": " + message);
        return true; // Assume email was sent successfully
    }

    private boolean sendSms(Long userId, String message) {
        // Mock implementation for sending SMS
        System.out.println("Sending SMS to userId " + userId + ": " + message);
        return true; // Assume SMS was sent successfully
    }

    private boolean sendPushNotification(Long userId, String message) {
        // Mock implementation for sending push notifications
        System.out.println("Sending PUSH notification to userId " + userId + ": " + message);
        return true; // Assume push notification was sent successfully
    }
}

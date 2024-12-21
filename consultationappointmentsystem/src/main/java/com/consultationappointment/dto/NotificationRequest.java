package com.consultationappointment.dto;

import lombok.Data;

@Data
public class NotificationRequest {
    private Long userId;
    private String channel; // Options: "EMAIL", "SMS", "PUSH"
    private String message;
}

package com.consultationappointment.dto;

import lombok.Data;

@Data

public class NotificationResponse {
    private String status; // "SUCCESS" or "FAILED"
    private String message; // Detailed status message
}

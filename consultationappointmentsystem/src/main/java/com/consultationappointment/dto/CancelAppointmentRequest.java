package com.consultationappointment.dto;

import lombok.Data;

@Data
public class CancelAppointmentRequest {
    private Long appointmentId;
    private String reason; // Optional reason for cancellation
}

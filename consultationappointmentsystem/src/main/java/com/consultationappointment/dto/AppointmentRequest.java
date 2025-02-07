package com.consultationappointment.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class AppointmentRequest {
    private Long doctorId;
    private Long userId;
    private LocalDateTime appointmentTime;
}

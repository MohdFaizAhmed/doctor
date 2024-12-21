package com.consultationappointment.dto;

import lombok.Data;

@Data
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialization;
    private String location;
    private String experience;
}

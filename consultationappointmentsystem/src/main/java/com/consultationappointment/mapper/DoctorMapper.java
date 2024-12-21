//package com.consultationappointment.mapper;
//import org.springframework.stereotype.Component;
//
//import com.consultationappointment.dto.DoctorDto;
//import com.consultationappointment.entity.Doctor;
//
//@Component
//public class DoctorMapper {
//
//    public DoctorDto toDto(Doctor doctor) {
//        DoctorDto dto = new DoctorDto();
//        dto.setId(doctor.getId());
//        dto.setName(doctor.getName());
//        dto.setSpecialization(doctor.getSpecialization());
//        dto.setExperience(doctor.getExperience());
//        dto.setAvailability(doctor.getAvailability());
//        dto.setRating(doctor.getRating());
//        return dto;
//    }
//
//    public Doctor toEntity(DoctorDto dto) {
//        Doctor doctor = new Doctor();
//        doctor.setName(dto.getName());
//        doctor.setSpecialization(dto.getSpecialization());
//        doctor.setExperience(dto.getExperience());
//        doctor.setAvailability(dto.getAvailability());
//        doctor.setRating(dto.getRating());
//        return doctor;
//    }
//}

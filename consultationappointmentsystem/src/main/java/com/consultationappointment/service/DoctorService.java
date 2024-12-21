package com.consultationappointment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.consultationappointment.dto.DoctorResponse;
import com.consultationappointment.entity.Doctor;
import com.consultationappointment.repo.DoctorRepository;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorResponse> searchDoctors(String specialization, String location) {
        List<Doctor> doctors = doctorRepository.findBySpecializationContainingIgnoreCaseAndLocationContainingIgnoreCase(
                specialization == null ? "" : specialization,
                location == null ? "" : location
        );

        return doctors.stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public DoctorResponse getDoctorById(Long id) {
        Optional<Doctor> doctor = doctorRepository.findById(id);
        if (doctor.isEmpty()) {
            throw new RuntimeException("Doctor not found with id: " + id);
        }
        return mapToResponse(doctor.get());
    }

    private DoctorResponse mapToResponse(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setSpecialization(doctor.getSpecialization());
        response.setLocation(doctor.getLocation());
        response.setExperience(doctor.getExperience());
        return response;
    }
}

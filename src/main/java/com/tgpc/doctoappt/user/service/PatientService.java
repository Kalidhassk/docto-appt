package com.tgpc.doctoappt.user.service;

import com.tgpc.doctoappt.user.dto.DoctorResponse;
import com.tgpc.doctoappt.user.dto.PatientRequest;
import com.tgpc.doctoappt.user.dto.PatientResponse;
import com.tgpc.doctoappt.user.model.Doctor;
import com.tgpc.doctoappt.user.model.Patient;
import com.tgpc.doctoappt.user.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public PatientResponse findById(Long id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isPresent()) {
            Patient patient = patientOptional.get();
            return new PatientResponse(patient.getId(), patient.getName(), patient.getAddress(), patient.getPinCode());
        }
        return null;
    }

    public PatientResponse save(PatientRequest patientRequest) {
        Patient patient = patientRepository.findByEmail(patientRequest.email());
        if (patient == null) {
            patient = mapToPatient(patientRequest);
            patient = patientRepository.save(patient);
        }
        return new PatientResponse(patient.getId(), patient.getName(), patient.getAddress(), patient.getPinCode());
    }

    private Patient mapToPatient(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setName(patientRequest.name());
        patient.setEmail(patientRequest.email());
        patient.setPassword(patientRequest.password());
        patient.setAddress(patientRequest.address());
        patient.setPinCode(patientRequest.pinCode());
        return patient;
    }

    public void deleteById(Long id) {
        patientRepository.deleteById(id);
    }
}

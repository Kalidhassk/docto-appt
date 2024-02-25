package com.tgpc.doctoappt.user.service;

import com.tgpc.doctoappt.user.dto.PatientRequest;
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

    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient save(PatientRequest patientRequest) {
        Patient patient = mapToPatient(patientRequest);
        return patientRepository.save(patient);
    }

    private Patient mapToPatient(PatientRequest patientRequest){
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

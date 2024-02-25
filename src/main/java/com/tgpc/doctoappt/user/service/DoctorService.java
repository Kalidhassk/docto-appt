package com.tgpc.doctoappt.user.service;

import com.tgpc.doctoappt.user.dto.DoctorRequest;
import com.tgpc.doctoappt.user.model.Doctor;
import com.tgpc.doctoappt.user.model.Patient;
import com.tgpc.doctoappt.user.model.SpecialityEnum;
import com.tgpc.doctoappt.user.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor save(DoctorRequest doctorRequest) {
        Doctor doctor = mapToDoctor(doctorRequest);
        return doctorRepository.save(doctor);
    }

    private Doctor mapToDoctor(DoctorRequest doctorRequest){
        Doctor doctor = new Doctor();
        doctor.setName(doctorRequest.name());
        doctor.setEmail(doctorRequest.email());
        doctor.setPassword(doctorRequest.password());
        doctor.setAddress(doctorRequest.address());
        doctor.setPinCode(doctorRequest.pinCode());
        SpecialityEnum specialityEnum = SpecialityEnum.valueOf(doctorRequest.speciality());
        doctor.setSpecialityEnum(specialityEnum);
        doctor.setHospitalName(doctorRequest.hospitalName());
        return doctor;
    }

    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}

package com.tgpc.doctoappt.user.service;

import com.tgpc.doctoappt.user.dto.DoctorRequest;
import com.tgpc.doctoappt.user.dto.DoctorResponse;
import com.tgpc.doctoappt.user.model.Doctor;
import com.tgpc.doctoappt.user.model.Patient;
import com.tgpc.doctoappt.user.model.SpecialityEnum;
import com.tgpc.doctoappt.user.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public List<DoctorResponse> findAll() {
        List<Doctor> doctorList = doctorRepository.findAll();
        if(!doctorList.isEmpty()){
            return doctorList.stream().map(this::mapToDoctorResponse).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private DoctorResponse mapToDoctorResponse(Doctor doctor){
        return new DoctorResponse(doctor.getId(), doctor.getName(), doctor.getHospitalName(), doctor.getSpecialityEnum().name(), doctor.getAddress(), doctor.getPinCode());
    }

    public DoctorResponse findById(Long id) {
        Optional<Doctor> doctorOptional = doctorRepository.findById(id);
        if(doctorOptional.isPresent()){
            Doctor doctor = doctorOptional.get();
            return mapToDoctorResponse(doctor);
        }
        return null;
    }

    public DoctorResponse save(DoctorRequest doctorRequest) {
        String email = doctorRequest.email();
        Doctor doctor = doctorRepository.findByEmail(email);
        if(doctor == null){
            doctor = mapToDoctor(doctorRequest);
            doctor = doctorRepository.save(doctor);
        }
        return mapToDoctorResponse(doctor);
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

    public List<DoctorResponse> searchDoctors(String query){
        List<Doctor> doctorList = doctorRepository.searchDoctors(query);
        return doctorList.stream().map(this::mapToDoctorResponse).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        doctorRepository.deleteById(id);
    }
}

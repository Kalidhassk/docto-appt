package com.tgpc.doctoappt.user.controller;

import com.tgpc.doctoappt.user.dto.PatientRequest;
import com.tgpc.doctoappt.user.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPatient(@RequestBody PatientRequest patientRequest){
        patientService.save(patientRequest);
        return "Patient Created Successfully";
    }
}

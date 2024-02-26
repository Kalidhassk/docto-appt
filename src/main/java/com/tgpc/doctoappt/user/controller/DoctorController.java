package com.tgpc.doctoappt.user.controller;

import com.tgpc.doctoappt.appointment.dto.AppointmentResponse;
import com.tgpc.doctoappt.user.dto.DoctorRequest;
import com.tgpc.doctoappt.user.dto.DoctorResponse;
import com.tgpc.doctoappt.user.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createDoctor(@RequestBody DoctorRequest doctorRequest){
        doctorService.save(doctorRequest);
        return "User Created Successfully";
    }

    @GetMapping
    public List<DoctorResponse> getDoctors(){
        return doctorService.findAll();
    }

    @GetMapping(value = "/{id}")
    public DoctorResponse getDoctorDetails(@PathVariable("id") Long doctorId){
        return doctorService.findById(doctorId);
    }
}

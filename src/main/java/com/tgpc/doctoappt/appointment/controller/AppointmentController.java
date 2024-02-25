package com.tgpc.doctoappt.appointment.controller;

import com.tgpc.doctoappt.appointment.dto.AppointmentRequest;
import com.tgpc.doctoappt.appointment.dto.AppointmentResponse;
import com.tgpc.doctoappt.appointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createDoctor(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.save(appointmentRequest);
        return "Appointment Created Successfully";
    }

    @GetMapping(value = "/patient/{id}")
    public List<AppointmentResponse> getAppointmentsForPatient(@PathVariable("id") Long patientId){
        return appointmentService.findAppointmentsForPatient(patientId);
    }

    @GetMapping(value = "/doctor/{id}")
    public List<AppointmentResponse> getAppointmentsForDoctor(@PathVariable("id") Long doctorId){
        return appointmentService.findAppointmentsForDoctor(doctorId);
    }
}

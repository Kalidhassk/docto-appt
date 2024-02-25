package com.tgpc.doctoappt.appointment.service;

import com.tgpc.doctoappt.appointment.dto.AppointmentRequest;
import com.tgpc.doctoappt.appointment.dto.AppointmentResponse;
import com.tgpc.doctoappt.appointment.model.Appointment;
import com.tgpc.doctoappt.appointment.model.AppointmentStatusEnum;
import com.tgpc.doctoappt.appointment.repository.AppointmentRepository;
import com.tgpc.doctoappt.user.model.Doctor;
import com.tgpc.doctoappt.user.model.Patient;
import com.tgpc.doctoappt.user.repository.DoctorRepository;
import com.tgpc.doctoappt.user.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    public Appointment save(AppointmentRequest appointmentRequest) {
        Appointment appointment = mapToAppointment(appointmentRequest);
        return appointmentRepository.save(appointment);
    }

    private Appointment mapToAppointment(AppointmentRequest appointmentRequest){
        Appointment appointment = new Appointment();
        Optional<Doctor> doctor = doctorRepository.findById(appointmentRequest.doctorId());
        doctor.ifPresent(appointment::setDoctor);
        Optional<Patient> patient = patientRepository.findById(appointmentRequest.patientId());
        patient.ifPresent(appointment::setPatient);

        appointment.setAppointmentStatusEnum(AppointmentStatusEnum.SCHEDULED);
        appointment.setDate(appointmentRequest.date());
        appointment.setStartTime(appointmentRequest.startTime());
        appointment.setEndTime(appointmentRequest.endTime());
        return appointment;
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<AppointmentResponse> findAppointmentsForPatient(Long patientId) {
        List<Appointment> appointmentList = appointmentRepository.findByPatientId(patientId);
        return appointmentList.stream().map(appointment -> new AppointmentResponse(appointment.getId(), appointment.getDate(), appointment.getStartTime(), appointment.getEndTime())).collect(Collectors.toList());
    }

    public List<AppointmentResponse> findAppointmentsForDoctor(Long doctorId) {
        List<Appointment> appointmentList = appointmentRepository.findByDoctorId(doctorId);
        return appointmentList.stream().map(appointment -> new AppointmentResponse(appointment.getId(), appointment.getDate(), appointment.getStartTime(), appointment.getEndTime())).collect(Collectors.toList());
    }
}

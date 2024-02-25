package com.tgpc.doctoappt.appointment.model;

import com.tgpc.doctoappt.user.model.Doctor;
import com.tgpc.doctoappt.user.model.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "t_appointment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private AppointmentStatusEnum appointmentStatusEnum;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private Patient patient;
}

package com.tgpc.doctoappt.appointment.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponse(Long appointmentId, LocalDate date, LocalTime startTime, LocalTime endTime) {
}

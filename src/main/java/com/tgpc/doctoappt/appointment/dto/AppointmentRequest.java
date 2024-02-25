package com.tgpc.doctoappt.appointment.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequest(Long patientId, Long doctorId, @JsonSerialize(using = LocalDateSerializer.class) LocalDate date, @JsonSerialize(using = LocalTimeSerializer.class) LocalTime startTime, @JsonSerialize(using = LocalTimeSerializer.class) LocalTime endTime) {
}

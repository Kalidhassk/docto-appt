package com.tgpc.doctoappt.user.dto;

public record DoctorResponse(Long id, String name, String hospitalName, String speciality, String address, Integer pinCode) {
}

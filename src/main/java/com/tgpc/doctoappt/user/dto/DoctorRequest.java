package com.tgpc.doctoappt.user.dto;

public record DoctorRequest(String name, String hospitalName, String speciality, String email, String password, String role, String address, Integer pinCode) {
}

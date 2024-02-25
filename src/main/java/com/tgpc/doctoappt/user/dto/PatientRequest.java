package com.tgpc.doctoappt.user.dto;

public record PatientRequest (String name, String email, String password, String address, Integer pinCode){
}

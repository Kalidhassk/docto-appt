package com.tgpc.doctoappt.user.repository;

import com.tgpc.doctoappt.user.model.Doctor;
import jakarta.transaction.Transactional;

@Transactional
public interface DoctorRepository extends UserRepository<Doctor> {
}

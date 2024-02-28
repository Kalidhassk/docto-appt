package com.tgpc.doctoappt.user.repository;

import com.tgpc.doctoappt.user.model.Patient;
import jakarta.transaction.Transactional;

@Transactional
public interface PatientRepository extends UserRepository<Patient> {
    Patient findByEmail(String email);
}

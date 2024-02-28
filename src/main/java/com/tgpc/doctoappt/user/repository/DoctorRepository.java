package com.tgpc.doctoappt.user.repository;

import com.tgpc.doctoappt.user.model.Doctor;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Transactional
public interface DoctorRepository extends UserRepository<Doctor> {

    @Query("SELECT d FROM Doctor d WHERE " +
            "d.name LIKE CONCAT('%', :query, '%') " +
            "OR d.hospitalName LIKE CONCAT('%', :query, '%') " +
            "OR d.specialityEnum LIKE CONCAT('%', :query, '%')")
    List<Doctor> searchDoctors(String query);

    Doctor findByEmail(String email);
}

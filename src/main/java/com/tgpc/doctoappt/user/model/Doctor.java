package com.tgpc.doctoappt.user.model;

import com.tgpc.doctoappt.appointment.model.Appointment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Doctor extends User{

    private String hospitalName;

    @Enumerated(EnumType.STRING)
    private SpecialityEnum specialityEnum;

    @OneToMany
    private List<Appointment> appointmentList;
}

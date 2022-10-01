package com.example.SERVICES;

import com.example.MODELS.Appointment;
import com.example.REPOSITORIES.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }

    public Appointment addAppointment(Appointment appointment) {   //////////// ADD
        return appointmentRepo.save(appointment);
    } //////ADD

    public List<Appointment> findAllAppointment() {
        List<Appointment> appointments = appointmentRepo.findAll().stream().filter(new Predicate<Appointment>() {
            @Override
            public boolean test(Appointment appointment) {
                return !appointment.isCompleted();

            }
        }).sorted().collect(Collectors.toList());
        appointments.forEach(appointment -> {
            if (appointment.getLocalDateTime().isBefore(LocalDateTime.now())) {
                appointment.setHasPast(true);
            }

        });
        return appointments;
    }  //////GET ALL

    public Appointment updateAppointment(Appointment appointment) {
        return appointmentRepo.save(appointment);
    } //////UPDATE EMPLOYEE

    public void deleteAppointment(Long id) {
        appointmentRepo.deleteById(id);
    } //////DELETE BY ID

    public Appointment findById(Long id) {
        return appointmentRepo.findById(id).orElseThrow();
    } ///FIND BY ID


}

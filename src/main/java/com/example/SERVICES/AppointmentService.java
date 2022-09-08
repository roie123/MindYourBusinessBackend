package com.example.SERVICES;

import com.example.MODELS.Appointment;
import com.example.REPOSITORIES.AppointmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepo appointmentRepo;

    @Autowired
    public AppointmentService(AppointmentRepo appointmentRepo) {
        this.appointmentRepo = appointmentRepo;
    }
    public Appointment addAppointment(Appointment appointment){   //////////// ADD
        return appointmentRepo.save(appointment);
    } //////ADD

    public List<Appointment> findAllAppointment(){
        return appointmentRepo.findAll();
    }  //////GET ALL

    public Appointment updateAppointment(Appointment appointment){
        return appointmentRepo.save(appointment);
    } //////UPDATE EMPLOYEE

    public void deleteAppointment(Long id){
        appointmentRepo.deleteById(id);
    } //////DELETE BY ID

    public Appointment findById(Long id){
        return appointmentRepo.findById(id).orElseThrow();
    } ///FIND BY ID



}

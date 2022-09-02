package com.example.MODELS;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<SomeService> allowedProceduresToPerform=new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    Set<Appointment> appointments =new HashSet<>();

    public Employee() {
    }
public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
}
    public void addAllowedService(SomeService someService){
        this.allowedProceduresToPerform.add(someService);
    }
    public Employee(Long id, String firstName, String lastName, int yearsOfExperience, Set<SomeService> allowedProceduresToPerform, Set<Appointment> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.allowedProceduresToPerform = allowedProceduresToPerform;
        this.appointments = appointments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Set<SomeService> getAllowedProceduresToPerform() {
        return allowedProceduresToPerform;
    }

    public void setAllowedProceduresToPerform(Set<SomeService> allowedProceduresToPerform) {
        this.allowedProceduresToPerform = allowedProceduresToPerform;
    }

//    public Set<Appointment> getAppointments() {
//        return appointments;
//    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

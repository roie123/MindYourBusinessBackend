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
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<SomeService> allowedProceduresToPerform=new HashSet<>();
    private String position;
    private String email;
    public int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Employee(Long id, String firstName, String lastName, int yearsOfExperience, boolean isActive, Set<SomeService> allowedProceduresToPerform, String position, String email, Set<Appointment> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsOfExperience = yearsOfExperience;
        this.isActive = isActive;
        this.allowedProceduresToPerform = allowedProceduresToPerform;
        this.position = position;
        this.email = email;
        this.appointments = appointments;
    }

    @OneToMany(cascade = CascadeType.ALL)
    Set<Appointment> appointments =new HashSet<>();

    public Employee() {
    }

    public String getPosition() {
        return position;
    }

    public Employee setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public Employee addAppointment(Appointment appointment){
        this.appointments.add(appointment);
        return this;
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

    public Employee setFirstName(String firstName) {
        this.firstName = firstName; return  this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public Employee setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
        return this;
    }

    public Set<SomeService> getAllowedProceduresToPerform() {
        return allowedProceduresToPerform;
    }

    public Employee setAllowedProceduresToPerform(Set<SomeService> allowedProceduresToPerform) {
        this.allowedProceduresToPerform = allowedProceduresToPerform;
        return this;
    }

//    public Set<Appointment> getAppointments() {
//        return appointments;
//    }

    public Employee setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

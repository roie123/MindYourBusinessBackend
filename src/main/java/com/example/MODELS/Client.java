package com.example.MODELS;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private boolean isActive;
    @OneToMany
    private Set<SomeService> procedureSet=new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public Client() {
    }

    public void addAppointment(Appointment appointment){

    }

    public Client(Long id, String firstName, String lastName, String phoneNumber, boolean isActive, Set<SomeService> procedureSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.procedureSet = procedureSet;
    }

    public boolean isActive() {
        return isActive;
    }

    public Client setActive(boolean active) {
        isActive = active;
        return this;
    }

    public Client setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Client setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Client setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;return this;
    }

    public Set<SomeService> getProcedureSet() {
        return procedureSet;
    }

    public Client setProcedureSet(Set<SomeService> procedureSet) {
        this.procedureSet = procedureSet;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

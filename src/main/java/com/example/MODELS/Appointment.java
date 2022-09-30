package com.example.MODELS;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    private SomeService someService;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(pattern="dd/MM/yyyy hh:mm")
    private LocalDateTime localDateTime;

    public Appointment() {
        this.localDateTime=LocalDateTime.now();
    }

    public Client getClient() {
        return client;
    }

    public Appointment(Long id, Client client, Employee employee, SomeService someService, LocalDateTime localDateTime) {
        this.id = id;
        this.client = client;
        this.employee = employee;
        this.someService = someService;
        this.localDateTime = localDateTime;
    }

    public Appointment setClient(Client client) {
        this.client = client; return this;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Appointment setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }

    public SomeService getSomeService() {
        return someService;
    }

    public Appointment setSomeService(SomeService someService) {
        this.someService = someService;
        return this;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public Appointment setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

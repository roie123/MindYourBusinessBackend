package com.example.MODELS;


import org.springframework.data.jpa.repository.query.Procedure;

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

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public SomeService getSomeService() {
        return someService;
    }

    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.example.MODELS;

import javax.persistence.*;

@Entity
public class SomeService {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean isActive;
    private String name;
    private int durationInMinutes;

    @ManyToOne
    private Employee employee;

    private int price;

    public SomeService() {
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public SomeService(Long id, String name, int durationInMinutes, Employee employee, int price) {
        this.id = id;
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.employee = employee;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

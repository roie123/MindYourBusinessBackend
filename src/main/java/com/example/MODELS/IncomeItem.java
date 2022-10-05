package com.example.MODELS;

import javax.persistence.*;

@Entity
public class IncomeItem {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int month;
    private String name;
    private String description;
    private int sum;
    private boolean isActive;

    public IncomeItem() {
    }

    public IncomeItem(Long id, int month, String name, String description, int sum, boolean isActive) {
        this.id = id;
        this.month = month;
        this.name = name;
        this.description = description;
        this.sum = sum;
        this.isActive = isActive;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

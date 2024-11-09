package com.example.spring_mvc.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int salary;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String transaction;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Student(int id, String name, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    }

    public Student(int id, String name, int salary, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public Student( String name, int salary, LocalDate dob) {
        this.name = name;
        this.salary = salary;
        this.dob = dob;
    }

    public Student(int id, String name, int salary, LocalDate dob, String transaction) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dob = dob;
        this.transaction = transaction;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

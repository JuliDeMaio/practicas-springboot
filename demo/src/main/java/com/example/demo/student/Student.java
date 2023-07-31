package com.example.demo.student;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long dni;
    private String name;
    private String mail;
    private LocalDate nac;
    @Transient
    private Integer age;


    public Student() {
    }

    public Student(Long dni, String name, String mail, LocalDate nac) {
        this.dni = dni;
        this.name = name;
        this.mail = mail;
        this.nac = nac;
    }

    public Student(String name, String mail, LocalDate nac) {
        this.name = name;
        this.mail = mail;
        this.nac = nac;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public LocalDate getNac() {
        return nac;
    }

    public void setNac(LocalDate nac) {
        this.nac = nac;
    }

    public Integer age() {
        return Period.between(this.getNac(), LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Student{" +
                "dni=" + dni +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", nac=" + nac +
                ", age=" + age +
                '}';
    }
}



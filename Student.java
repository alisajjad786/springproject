package com.spring.orm.entities;

import javax.persistence.*;

@Entity
@Table(name = "student_details")
public class Student {
    @Column(name = "student_depart")
    private String studentDepart;

    @Id
    private int studentId;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_city")
    private String studentCity;
    public String getStudentDepart() {
        return studentDepart;
    }

    public void setStudentDepart(String studentDepart) {
        this.studentDepart = studentDepart;
    }

    public int getStudentId(int idup) {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public Student() {
        super();
    }

    public Student(String studentDepart, int studentId, String studentName, String studentCity) {
        super();
        this.studentDepart = studentDepart;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }
}
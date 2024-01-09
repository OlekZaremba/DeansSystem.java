package com.example.deanssystem.model;

public class Student {

    private int studentId;
    private String name;
    private String lastName;
    private int fieldOfStudy;
    private int yearOfStart;

    public Student(String name, String lastName, int fieldOfStudy, int yearOfStart) {
        this.name = name;
        this.lastName = lastName;
        this.fieldOfStudy = fieldOfStudy;
        this.yearOfStart = yearOfStart;
    }

    public Student(int studentId, String name, String lastName, int fieldOfStudy, int yearOfStart) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.fieldOfStudy = fieldOfStudy;
        this.yearOfStart = yearOfStart;
    }


    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(int fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public int getYearOfStart() {
        return yearOfStart;
    }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }
}

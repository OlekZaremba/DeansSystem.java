package com.example.deanssystem.model;

public class SensitiveData {

    private int _id;
    private String PESEL;
    private String dateOfBirth;
    private String placeOfBirth;
    private String motherName;
    private String fatherName;

    public SensitiveData(String PESEL, String dateOfBirth, String placeOfBirth, String motherName, String fatherName) {
        this.PESEL = PESEL;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.motherName = motherName;
        this.fatherName = fatherName;
    }

    public int get_id() {
        return _id;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}

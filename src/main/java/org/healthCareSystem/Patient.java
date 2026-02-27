package org.healthCareSystem;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private String bloodType;
    private String medicalCondition;
    private Date dateOfAdmission;
    private String doctor;
    private String hospital;
    private int roomNumber;
    private String medication;
    private String testResult;

    public Patient(int id, String name, String bloodType, String medicalCondition, Date dateOfAdmission, String doctor, String hospital, int roomNumber, String medication, String testResult) {
        this.id = id;
        this.name = name;
        this.bloodType = bloodType;
        this.medicalCondition = medicalCondition;
        this.dateOfAdmission = dateOfAdmission;
        this.doctor = doctor;
        this.hospital = hospital;
        this.roomNumber = roomNumber;
        this.medication = medication;
        this.testResult = testResult;
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

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Date getDateOfAdmission() {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission) {
        this.dateOfAdmission = dateOfAdmission;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", medicalCondition='" + medicalCondition + '\'' +
                ", dateOfAdmission=" + dateOfAdmission +
                ", doctor='" + doctor + '\'' +
                ", hospital='" + hospital + '\'' +
                ", roomNumber=" + roomNumber +
                ", medication='" + medication + '\'' +
                ", testResult='" + testResult + '\'' +
                '}';
    }
}

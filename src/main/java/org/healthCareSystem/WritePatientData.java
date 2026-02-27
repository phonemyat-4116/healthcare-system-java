package org.healthCareSystem;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class WritePatientData {

    public void writeData(String filename, LinkedList<Patient> patients, boolean append){

        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename, append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        for(Patient patient : patients){
            String[] data = {String.valueOf(patient.getId()), patient.getName(), patient.getBloodType(),
            patient.getMedicalCondition(), sdf.format(patient.getDateOfAdmission()), patient.getDoctor(), patient.getHospital(),
            String.valueOf(patient.getRoomNumber()), patient.getMedication(), patient.getTestResult()};
            // for date : .format => date into string

            csvWriter.writeNext(data);
        }
        try {
            csvWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        WritePatientData writePatientData = new WritePatientData();

        Date date = new Date();

        Patient p = new Patient(55501,"Julia", "B", "Fever", date, "Henery", "SSC",
                345, "Para", "Normal");

        LinkedList<Patient> patients = new LinkedList<>();
        patients.add(p);

        writePatientData.writeData("data/healthcaredata2.csv", patients, true);
    }

}

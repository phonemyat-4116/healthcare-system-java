package org.healthCareSystem;

import de.vandermeer.asciitable.AsciiTable;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Search_MedicalRecord extends PatientPerformTemplate{
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();

    public Search_MedicalRecord(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void performOperation(String filename){
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Search Patient Data Record");
        System.out.println("==========================================");
        boolean patientFound = false;
        boolean flag = true;
        AsciiTable asciiTable = new AsciiTable();
        while(flag){
            String name = userInput.get_Name();

            for(Patient patient : patients){
                if(name.equals(patient.getName())){
                    if(!patientFound){
                        asciiTable.addRule();
                        asciiTable.addRow(Arrays.asList("ID", "Name", "Blood Type", "Medical Condition", "Date Of Admission", "Doctor",
                                "Hospital", "Room Number", "Medication", "Test Result"));
                        asciiTable.addRule();
                        patientFound = true;
                    }
                    asciiTable.addRow(Arrays.asList(patient.getId(), patient.getName(), patient.getBloodType(),
                            patient.getMedicalCondition(), sdf.format(patient.getDateOfAdmission()), patient.getDoctor(),
                            patient.getHospital(), patient.getRoomNumber(), patient.getMedication(), patient.getTestResult()));
                    asciiTable.addRule();
                }
            }

            if(patientFound){
                System.out.println(asciiTable.render());
                flag = false;
            }else{
                System.out.println("Patient data cannot be found");
            }
        }
    }

}

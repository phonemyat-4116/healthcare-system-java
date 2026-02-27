package org.healthCareSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Update_PatientData extends PatientPerformTemplate {
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();
    Scanner scan = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

    public Update_PatientData(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void performOperation(String filename) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Update Patient Data Record");
        System.out.println("==========================================");

        while (true){
            int id = userInput.get_Id();
            String name = userInput.get_Name();
            String newMedicalCondition;
            Date newDate;
            String newDoctor;
            String newHospital;
            int newRoomNumber;
            String newMedication;
            String newMedicalResult;


            for(Patient patient : patients){
                if(id == patient.getId() && name.equals(patient.getName())){

                    System.out.println("====== Enter Update Data ========");

                    newMedicalCondition = userInput.get_medicalCondition();
                    newDate = userInput.get_date();
                    newDoctor = userInput.get_Doctor();
                    newHospital = userInput.get_Hospital();
                    newRoomNumber = userInput.get_roomNumber();
                    newMedication = userInput.get_medication();
                    newMedicalResult = userInput.get_testResult();


                    patient.setMedicalCondition(newMedicalCondition);
                    patient.setDateOfAdmission(newDate);
                    patient.setDoctor(newDoctor);
                    patient.setHospital(newHospital);
                    patient.setRoomNumber(newRoomNumber);
                    patient.setMedication(newMedication);
                    patient.setTestResult(newMedicalResult);

                    new WritePatientData().writeData(filename, patients, false);
                    System.out.println("Successfully Updated");
                    return;
                }
            }
            System.out.println("The patient data cannot be found.");
        }

    }
}

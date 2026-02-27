package org.healthCareSystem;

import java.util.Date;
import java.util.LinkedList;

public class Insert_PatientData extends PatientPerformTemplate{
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();
    SearchInput searchInput = new SearchInput();

    public Insert_PatientData(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void performOperation(String filename) {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("Insert Patient Data Record");
        System.out.println("==========================================");

        boolean flag = true;

        while(flag){
            int id = userInput.get_Id();
            String name = userInput.get_Name();
            String bloodType = userInput.get_BloodType();
            String medicalCondition = userInput.get_medicalCondition();
            Date dateOfAdmission = userInput.get_date();
            String doctor = userInput.get_Doctor();
            String hospital = userInput.get_Hospital();
            int roomNumber = userInput.get_roomNumber();
            String medication = userInput.get_medication();
            String testResult = userInput.get_testResult();

            try {
                if(searchInput.search_id_name_date_blood(id, name, dateOfAdmission, bloodType, patients)){
                    patients.add(new Patient(id, name, bloodType, medicalCondition, dateOfAdmission, doctor, hospital,
                            roomNumber, medication, testResult));

                    new WritePatientData().writeData(filename, patients, false);
                    flag = false;
                }
            } catch (DuplicatePatientException e) {
                System.out.println("=========================");
                System.out.println("Error : " + e.getMessage());
                System.out.println("Re-enter again");
                System.out.println("=========================");
            }
        }

    }


}


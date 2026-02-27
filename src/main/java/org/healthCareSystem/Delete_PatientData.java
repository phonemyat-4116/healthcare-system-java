package org.healthCareSystem;

import java.util.LinkedList;

public class Delete_PatientData extends PatientPerformTemplate{
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();
    public Delete_PatientData(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void performOperation(String filename){
        System.out.println();
        System.out.println("==========================================");
        System.out.println("Delete Patient Data Record");
        System.out.println("==========================================");

        boolean isDeleted = false;
        while(true){
            int id = userInput.get_Id();
            String name = userInput.get_Name();

            for(Patient patient : patients){
                if(id == patient.getId() && name.equals(patient.getName())){
                    patients.remove(patient);
                    new WritePatientData().writeData(filename, patients, false);
                    System.out.println("Successfully Deleted");
                    isDeleted = true;
                    break; // exit the for loop
                }
            }
            if(isDeleted){
                break; // exit the while loop after deletion
            }
            System.out.println("The patient data cannot be found");
        }
    }
}


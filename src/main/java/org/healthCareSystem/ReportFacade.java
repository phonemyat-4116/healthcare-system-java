package org.healthCareSystem;

import java.util.LinkedList;

public class ReportFacade {
    private Report doctorLists;
    private Report totalPatientsByMedicalCondition;
    private Report medicalResults;

    LinkedList<Patient> patients = new LinkedList<>();

    public ReportFacade(LinkedList<Patient> patients){
        doctorLists = new View_DoctorsByMedicalCondition(patients);
        medicalResults = new View_MedicalResult(patients);
        totalPatientsByMedicalCondition = new View_TotalPatientByEachMedicalCondition(patients);
        this.patients = patients;
    }

    public void viewDoctors(){
        doctorLists.view();
    }

    public void viewTotalPatientsByMedicalCondition(){
        totalPatientsByMedicalCondition.view();
    }

    public void viewMedicalResult(){
        medicalResults.view();
    }
}


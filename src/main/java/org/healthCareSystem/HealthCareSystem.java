package org.healthCareSystem;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class HealthCareSystem implements HealthCare {
    public LinkedList<Patient> patients = new LinkedList<>();
    static Scanner scan = new Scanner(System.in);

    String filename = "data/healthcaredata2.csv";

    ReportFacade reportFacade = new ReportFacade(patients);

    public void menu(){
        System.out.println("========== Welcome to Health Care Management System ===========");
        System.out.println("1. Insert Patient Data");
        System.out.println("2. Update Patient Data");
        System.out.println("3. Delete Patient Data");
        System.out.println("4. Search Medical Record");
        System.out.println("5. View Doctor Lists");
        System.out.println("6. View Total Number Of Patients By Each Medical Condition");
        System.out.println("7. View Medical Results By Name");
        System.out.println("8. Exit");
        System.out.print("Choose one : ");
    }

    public String getOption(){
        String option = scan.nextLine();
        if(!Pattern.matches("[1-8]", option)){
            System.out.println("Enter Menu Number only 1 to 8");
            return getOption();
        }
        return option;
    }

    public void display(){

        menu();
        String option = getOption();

        switch (option){
            case "1":
                insert_Patient();
                display();
                break;

            case "2":
                update_Patient();
                display();
                break;

            case "3":
                delete_Patient();
                display();
                break;

            case "4":
                search_MedicalRecord();
                display();
                break;

            case "5":
                view_Doctors();
                display();
                break;

            case "6":
                view_PatientsByMedicalCondition();
                display();
                break;

            case "7":
                view_MedicalResult();
                display();
                break;

            case "8":
                exit();
        }
    }

    public void exit(){
        System.out.println("......Thank You ^_^.......");
        System.exit(0);
    }

    public void run(){

        ReadPatientData readPatientData = new ReadPatientData();
        readPatientData.readData("data/healthcaredata2.csv", patients);

        // call on this same instance to keep the patient lists
        this.display();
    }

    @Override
    public void insert_Patient() {
        PatientPerformTemplate insertOperation = new Insert_PatientData(patients);
        insertOperation.execute();
    }

    @Override
    public void update_Patient() {
        PatientPerformTemplate updateOperation = new Update_PatientData(patients);
        updateOperation.execute();
    }

    @Override
    public void delete_Patient() {
        PatientPerformTemplate deleteOperation = new Delete_PatientData(patients);
        deleteOperation.execute();
    }

    @Override
    public void search_MedicalRecord() {
        PatientPerformTemplate searchOperation = new Search_MedicalRecord(patients);
        searchOperation.execute();
//        new Search_MedicalRecord(patients).searchRecordByPatient("data/healthcaredata2.csv");
    }

    @Override
    public void view_Doctors() {
        reportFacade.viewDoctors();
    }

    @Override
    public void view_PatientsByMedicalCondition() {
        reportFacade.viewTotalPatientsByMedicalCondition();
    }

    @Override
    public void view_MedicalResult() {
        reportFacade.viewMedicalResult();
    }


}

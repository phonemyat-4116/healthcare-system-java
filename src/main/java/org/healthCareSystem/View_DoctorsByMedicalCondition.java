package org.healthCareSystem;

import com.opencsv.CSVWriter;
import de.vandermeer.asciitable.AsciiTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class View_DoctorsByMedicalCondition implements Report {
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();
    Scanner scan = new Scanner(System.in);

    public View_DoctorsByMedicalCondition(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void view(){
        System.out.println();
        System.out.println("==========================================");
        System.out.println("Insert Patient Data Record");
        System.out.println("==========================================");

        Set<String> doctors = new HashSet<>();
        for(Patient patient : patients){
            doctors.add(patient.getDoctor());
        }
        Set<String> uniqueRecord = new HashSet<>();

        LinkedList<Patient> temps = new LinkedList<>();

        for(Patient patient : patients){
            String uniqueCombination = patient.getDoctor() + "|" + patient.getMedicalCondition() + "|" +patient.getHospital();

            if(!uniqueRecord.contains(uniqueCombination)){
                uniqueRecord.add(uniqueCombination);
                temps.add(patient);
            }
        }
        temps.sort(Comparator.comparing(Patient::getDoctor));

        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(Arrays.asList("Doctor", "Medical Condition", "Hospital"));
        asciiTable.addRule();

        for(Patient temp : temps){
            asciiTable.addRow(Arrays.asList(temp.getDoctor(), temp.getMedicalCondition(), temp.getHospital()));
            asciiTable.addRule();
        }

        System.out.println(asciiTable.render());
        System.out.println();

        System.out.println("Size : " + patients.size());
    }



    /*
    public void viewDoctorLists() {
        HashMap<String, LinkedList<Patient>> doctorMap = new HashMap<>();

        // Group patients by doctor
        for (Patient patient : patients) {
            String doctor = patient.getDoctor();
            if (!doctorMap.containsKey(doctor)) {
                doctorMap.put(doctor, new LinkedList<>());
            }
            doctorMap.get(doctor).add(patient);
        }

        // Print the result
        System.out.println("==============================");
        System.out.printf("%-25s%-20s%-25s\n", "Doctor", "MedicalCondition", "Hospital");
        System.out.println("==============================");

        // Iterate over the doctorMap and print patient details grouped by doctor
        for (String doctor : doctorMap.keySet()) {
            for (Patient docPatient : doctorMap.get(doctor)) {
                System.out.printf("%-25s%-20s%-25s\n",
                        docPatient.getDoctor(), docPatient.getMedicalCondition(), docPatient.getHospital());
            }
            System.out.println("------------------------------");
        }
    }


    //        System.out.println("===============================================================");
//        System.out.printf("%-25s%-20s%-25s\n",
//                "Doctor","MedicalCondition","Hospital");
//        System.out.println("===============================================================");


//        System.out.printf("%-25s%-20s%-25s\n",
//                    temp.getDoctor(), temp.getMedicalCondition(), temp.getHospital());

     */
}

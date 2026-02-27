package org.healthCareSystem;

import de.vandermeer.asciitable.AsciiTable;

import java.util.*;

public class View_MedicalResult implements Report {
    LinkedList<Patient> patients = new LinkedList<>();
    UserInput userInput = UserInput.getUserInputInstance();

    public View_MedicalResult(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void view(){

        System.out.println();
        System.out.println("==========================================");
        System.out.println("View Medical Result");
        System.out.println("==========================================");

        String name = userInput.get_Name();

        Set<Patient> tempPatients = new HashSet<>(patients);

        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(Arrays.asList("Medication", "Medical Result", "Medical Condition", "Patient Name"));
        asciiTable.addRule();

        for(Patient temp : tempPatients){
            if(name.equals(temp.getName())){
                asciiTable.addRow(Arrays.asList(temp.getMedication(), temp.getTestResult(), temp.getMedicalCondition(), temp.getName()));
                asciiTable.addRule();
            }
        }
        System.out.println(asciiTable.render());
        System.out.println();
    }
}

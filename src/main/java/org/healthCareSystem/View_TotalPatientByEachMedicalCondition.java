package org.healthCareSystem;

import de.vandermeer.asciitable.AsciiTable;

import java.util.*;

public class View_TotalPatientByEachMedicalCondition implements Report{
    LinkedList<Patient> patients = new LinkedList<>();

    public View_TotalPatientByEachMedicalCondition(LinkedList<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public void view(){
        System.out.println();
        System.out.println("==========================================");
        System.out.println("View Total Number Of Patients By Each Medical Condition");
        System.out.println("==========================================");

        // Create list from map
        LinkedList<Map.Entry<String, Integer>> lists = getEntries();

        long startTime = System.currentTimeMillis();
        lists.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;



        AsciiTable asciiTable = new AsciiTable();
        asciiTable.addRule();
        asciiTable.addRow(Arrays.asList("No", "Medical Condition", "Total Number Of Patient"));
        asciiTable.addRule();

        int no = 1;
        for(Map.Entry en : lists){
            asciiTable.addRow(Arrays.asList(no, en.getKey(), en.getValue()));
            asciiTable.addRule();
            no++;
        }

        System.out.println(asciiTable.render());


        System.out.println("Total time = " + totalTime + " ms");

        Runtime runtime = Runtime.getRuntime();
        runtime.gc();

        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory Bytes : " + memory + " bytes");
        System.out.println("Memory by megabytes : " + memory/(1024L * 1024L) + " mega bytes");
    }

    private LinkedList<Map.Entry<String, Integer>> getEntries() {
        Set<Patient> tempPatients = new HashSet<>(patients);

        TreeMap<String, Integer> medicalTreeMap = new TreeMap<>();
        for(Patient temp : tempPatients){
            if(medicalTreeMap.containsKey(temp.getMedicalCondition())){
                int count = medicalTreeMap.get(temp.getMedicalCondition());
                medicalTreeMap.replace(temp.getMedicalCondition(), ++count);

            }else{
                medicalTreeMap.put(temp.getMedicalCondition(),1);
            }
        }
        return new LinkedList<>(medicalTreeMap.entrySet());
    }
}

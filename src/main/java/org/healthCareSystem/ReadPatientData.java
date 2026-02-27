package org.healthCareSystem;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class ReadPatientData {

    static LinkedList<Patient> patients = new LinkedList<>();

    public void readData(String filename, LinkedList<Patient> patients){

        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        CSVReader csvReader = new CSVReader(fileReader);
        String[] lines;
        while(true){
            try {
                if ((lines = csvReader.readNext()) == null) break;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }
            try {
                patients.add(new Patient(Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        lines[3],
                        sdf.parse(lines[4]), // string into date
                        lines[5],
                        lines[6],
                        Integer.parseInt(lines[7]),
                        lines[8],
                        lines[9]));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            csvReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.healthCareSystem;

import org.stringtemplate.v4.ST;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class SearchInput {

    public boolean search_id_name_date_blood(int id, String name, Date date, String blood, LinkedList<Patient> patients)
            throws DuplicatePatientException {
        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");

        String inputDate = sdf.format(date);

        for(Patient patient : patients){
            if(id == patient.getId()){
                throw new DuplicatePatientException("Same ID");
            }
            // Ignore Time, only compare date
            String existingDate = sdf.format(patient.getDateOfAdmission());

            if(name.equalsIgnoreCase(patient.getName()) && inputDate.equals(existingDate)
            && blood.equals(patient.getBloodType())){
                throw new DuplicatePatientException("Patient with that date already exist");
            }
        }
        return true;
    }

}

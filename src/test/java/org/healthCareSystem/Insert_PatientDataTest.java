package org.healthCareSystem;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Insert_PatientDataTest {

    LinkedList<Patient> patients;
    UserInput userInput;
    SearchInput searchInput;
    ReadPatientData readPatientData;
    SimpleDateFormat sdf;

    @Before
    public void setUp() throws Exception {
        patients = new LinkedList<>();
        readPatientData = new ReadPatientData();
        readPatientData.readData("data/healthcaredata2.csv", patients);
        sdf = new SimpleDateFormat("M/dd/yyyy");

        userInput = mock(UserInput.class);
        searchInput = mock(SearchInput.class);

        // Mocking user input to return predefined values
        when(userInput.get_Id()).thenReturn(55501);
        when(userInput.get_Name()).thenReturn("Jessica Carter");
        when(userInput.get_BloodType()).thenReturn("O");
        when(userInput.get_medicalCondition()).thenReturn("Asthma");
        when(userInput.get_date()).thenReturn(sdf.parse("4/25/2021"));
        when(userInput.get_Doctor()).thenReturn("Laura Green");
        when(userInput.get_Hospital()).thenReturn("Medical Associates PLC");
        when(userInput.get_roomNumber()).thenReturn(312);
        when(userInput.get_medication()).thenReturn("Ibuprofen");
        when(userInput.get_testResult()).thenReturn("Normal");

        // Mocking search input
        when(searchInput.search_id_name_date_blood(
                eq(55501),
                eq("Jessica Carter"),
                eq(sdf.parse("4/25/2021")),
                eq("O"),
                eq(patients)
        )).thenReturn(true);
    }

    @Test
    public void performOperation() throws Exception {
        Insert_PatientData insertPatientData = new Insert_PatientData(patients);

        insertPatientData.userInput = userInput; // Inject mocked UserInput
        insertPatientData.searchInput = searchInput; // Inject mocked SearchInput

        PatientPerformTemplate insertPatient = new Insert_PatientData(patients);
        insertPatientData.execute();
    }
}
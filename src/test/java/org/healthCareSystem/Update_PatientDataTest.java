package org.healthCareSystem;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Update_PatientDataTest {

    LinkedList<Patient> patients;
    UserInput userInput;
    ReadPatientData readPatientData;
    WritePatientData writePatientData;
    SimpleDateFormat sdf;

    @Before
    public void setUp() throws Exception {
        patients = new LinkedList<>();
        readPatientData = new ReadPatientData();
        readPatientData.readData("data/healthcaredata2.csv", patients);
        sdf = new SimpleDateFormat("M/dd/yyyy");

        userInput = mock(UserInput.class);

        when(userInput.get_Id()).thenReturn(55501);
        when(userInput.get_Name()).thenReturn("Jessica Carter");
        when(userInput.get_medicalCondition()).thenReturn("Asthma");
        when(userInput.get_date()).thenReturn(sdf.parse("4/25/2021"));
        when(userInput.get_Doctor()).thenReturn("Rachel");
        when(userInput.get_Hospital()).thenReturn("ABC");
        when(userInput.get_roomNumber()).thenReturn(312);
        when(userInput.get_medication()).thenReturn("Ibuprofen");
        when(userInput.get_testResult()).thenReturn("Abnormal");
    }

    @Test
    public void performOperation() {
        Update_PatientData updatePatientData = new Update_PatientData(patients);

        updatePatientData.userInput = userInput;

        PatientPerformTemplate updatePatient = new Update_PatientData(patients);
        updatePatientData.execute();
    }
}
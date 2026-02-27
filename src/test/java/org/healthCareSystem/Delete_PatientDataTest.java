package org.healthCareSystem;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Delete_PatientDataTest {

    LinkedList<Patient> patients;
    UserInput userInput;
    ReadPatientData readPatientData;

    @Before
    public void setUp() throws Exception {
        patients = new LinkedList<>();
        readPatientData = new ReadPatientData();
        readPatientData.readData("data/healthcaredata2.csv", patients);

        userInput = mock(UserInput.class);

        when(userInput.get_Id()).thenReturn(55501);
        when(userInput.get_Name()).thenReturn("Jessica Carter");
    }

    @Test
    public void performOperation() {
        Delete_PatientData deletePatientData = new Delete_PatientData(patients);

        deletePatientData.userInput = userInput;

        PatientPerformTemplate deletePatient = new Delete_PatientData(patients);
        deletePatientData.execute();
    }
}
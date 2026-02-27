package org.healthCareSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserInputTest {

    SimpleDateFormat sdf;
    UserInput userInput;

    @Before
    public void setUp() throws Exception {
        sdf = new SimpleDateFormat("M/dd/yyyy");

        userInput = mock(UserInput.class);
    }

    @Test
    public void testGetId_ValidInput() {
        when(userInput.get_Id()).thenReturn(123);
        assertEquals(123, userInput.get_Id());
    }

    @Test
    public void get_Name() {
        when(userInput.get_Name()).thenReturn("Jame Carter");
        assertEquals("Jame Carter", userInput.get_Name());
    }

    @Test
    public void get_BloodType() {
        when(userInput.get_BloodType()).thenReturn("O");
        assertEquals("O", userInput.get_BloodType());
    }

    @Test
    public void get_medicalCondition() {
        when(userInput.get_medicalCondition()).thenReturn("Asthma");
        assertEquals("Asthma", userInput.get_medicalCondition());
    }

    @Test
    public void get_date() {
        try {
            when(userInput.get_date()).thenReturn(sdf.parse("10/12/2024"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            assertEquals(sdf.parse("10/12/2024"), userInput.get_date());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void get_Doctor() {
        when(userInput.get_Doctor()).thenReturn("DR.David");
        assertEquals("DR.David", userInput.get_Doctor());
    }

    @Test
    public void get_Hospital() {
        when(userInput.get_Hospital()).thenReturn("Sunway");
        assertEquals("Sunway", userInput.get_Hospital());
    }

    @Test
    public void get_roomNumber() {
        when(userInput.get_roomNumber()).thenReturn(256);
        assertEquals(256, userInput.get_roomNumber());
    }

    @Test
    public void get_medication() {
        when(userInput.get_medication()).thenReturn("Paracetamol");
        assertEquals("Paracetamol", userInput.get_medication());
    }

    @Test
    public void get_testResult() {
        when(userInput.get_testResult()).thenReturn("Normal");
        assertEquals("Normal", userInput.get_testResult());
    }
}
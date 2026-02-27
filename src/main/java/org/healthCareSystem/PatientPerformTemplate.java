package org.healthCareSystem;

public abstract class PatientPerformTemplate {
    abstract void performOperation(String filename);

    public final void execute(){
        performOperation("data/healthcaredata2.csv");
    }
}

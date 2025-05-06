package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "caseID")
public class Theft extends CrimeCase {

    private String stolenItemDescription;
    private String lossAmount;
    private String crowdDensity;

    public Theft() {
        super();  // Ensure CrimeCase has a no-arg constructor
    }

    public Theft(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                 int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                 String motive, CrimeType crimeType, String stolenItemDescription, String lossAmount, String crowdDensity) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.stolenItemDescription = stolenItemDescription;
        this.lossAmount = lossAmount;
        this.crowdDensity = crowdDensity;
    }

    // Getters and Setters
    public String getStolenItemDescription() {
        return stolenItemDescription;
    }

    public void setStolenItemDescription(String stolenItemDescription) {
        this.stolenItemDescription = stolenItemDescription;
    }

    public String getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(String lossAmount) {
        this.lossAmount = lossAmount;
    }

    public String getCrowdDensity() {
        return crowdDensity;
    }

    public void setCrowdDensity(String crowdDensity) {
        this.crowdDensity = crowdDensity;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Stolen Item Description: " + stolenItemDescription);
        System.out.println("Loss Amount: " + lossAmount);
        System.out.println("Crowd Density: " + crowdDensity);
    }
}

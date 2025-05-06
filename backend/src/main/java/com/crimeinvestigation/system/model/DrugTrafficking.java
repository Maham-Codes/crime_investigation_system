package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "caseID")
public class DrugTrafficking extends CrimeCase {

    private String drugType;
    private String quantity;
    private String storageMethod;

    public DrugTrafficking() {
        super(); // default constructor of CrimeCase
    }

    public DrugTrafficking(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                           int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                           String motive, CrimeType crimeType, String drugType, String quantity, String storageMethod) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.drugType = drugType;
        this.quantity = quantity;
        this.storageMethod = storageMethod;
    }

    // Getters and Setters
    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getStorageMethod() {
        return storageMethod;
    }

    public void setStorageMethod(String storageMethod) {
        this.storageMethod = storageMethod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Drug Type: " + drugType);
        System.out.println("Quantity: " + quantity);
        System.out.println("Storage Method: " + storageMethod);
    }
}

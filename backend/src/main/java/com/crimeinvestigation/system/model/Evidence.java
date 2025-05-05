package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

@Entity
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evidenceID;

    private int caseID;
    private int userID;
    private String evidenceType;

    public Evidence() {}  // Default constructor required by JPA

    public Evidence(int evidenceID, int caseID, int userID, String evidenceType) {
        this.evidenceID = evidenceID;
        this.caseID = caseID;
        this.userID = userID;
        this.evidenceType = evidenceType;
    }

    public int getEvidenceID() { return evidenceID; }
    public int getCaseID() { return caseID; }
    public int getUserID() { return userID; }
    public String getEvidenceType() { return evidenceType; }

    public void setEvidenceID(int evidenceID) { this.evidenceID = evidenceID; }
    public void setCaseID(int caseID) { this.caseID = caseID; }
    public void setUserID(int userID) { this.userID = userID; }
    public void setEvidenceType(String evidenceType) { this.evidenceType = evidenceType; }

    public void displayDetails() {
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Case ID: " + caseID);
        System.out.println("User ID: " + userID);
        System.out.println("Evidence Type: " + evidenceType);
    }
}


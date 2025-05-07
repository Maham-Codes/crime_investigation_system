package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.CaseStatus;
import jakarta.persistence.*;
import com.crimeinvestigation.system.enums.CrimeType;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CrimeCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseID;

    protected LocalDate date;
    protected LocalDateTime time;
    protected String location;
    protected String description;
    protected String caseStatus;
    protected int userID;
    protected int evidenceID;

    @Enumerated(EnumType.STRING)
    private CrimeType type;

    @Enumerated(EnumType.STRING)
    private CaseStatus status;

    @ManyToOne
    private Investigator assignedInvestigator;

    public CrimeCase(LocalDate date, LocalDateTime time, String location, String description, String status, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, int userID, int evidenceID, com.crimeinvestigation.system.model.CrimeType crimeType) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.caseStatus = status;
        this.userID = userID;
        this.evidenceID = evidenceID;
    }

    public CrimeCase(){}

    // Getters and Setters


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getEvidenceID() {
        return evidenceID;
    }

    public void setEvidenceID(int evidenceID) {
        this.evidenceID = evidenceID;
    }

    public CrimeType gettype() { return type; }
    public void settype(CrimeType type) { this.type = type; }


    public int getCaseID() { return caseID; }

    public void setCaseID(int caseID) { this.caseID = caseID; }

    public CaseStatus getStatus() { return status; }

    public void setStatus(CaseStatus status) { this.status = status; }

    public Investigator getAssignedInvestigator() { return assignedInvestigator; }

    public void setAssignedInvestigator(Investigator investigator) {
        this.assignedInvestigator = investigator;
    }
 public void displayDetails() {}
}

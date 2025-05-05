package com.crimeinvestigation.system.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CrimeCase {
    protected int caseID;
    protected LocalDate date;
    protected LocalDateTime time;
    protected String location;
    protected String description;
    protected String caseStatus;
    protected int userID;
    protected int evidenceID;

    public CrimeCase(int caseID, LocalDate date, LocalDateTime time, String location, String description, String status, int userID, int evidenceID) {
        this.caseID = caseID;
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.caseStatus = status;
        this.userID = userID;
        this.evidenceID = evidenceID;
    }

    // Getters and Setters
    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

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

}

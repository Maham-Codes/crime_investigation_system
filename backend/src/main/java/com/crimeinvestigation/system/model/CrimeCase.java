package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class CrimeCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int caseID;

    protected LocalDate date;
    protected LocalDateTime time;
    protected String location;
    protected String description;
    protected String caseStatus;

    protected boolean CCTVpresence;
    protected String weaponUsed;
    protected String injuryDetail;
    protected String motive;

    protected int userID;
    protected int evidenceID;

    @ManyToOne
    @JoinColumn(name = "crime_type_id")
    protected CrimeType crimeType;

    public CrimeCase() {}

    public CrimeCase(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                     boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive,
                     int userID, int evidenceID, CrimeType crimeType) {
        this.date = date;
        this.time = time;
        this.location = location;
        this.description = description;
        this.caseStatus = caseStatus;
        this.CCTVpresence = CCTVpresence;
        this.weaponUsed = weaponUsed;
        this.injuryDetail = injuryDetail;
        this.motive = motive;
        this.userID = userID;
        this.evidenceID = evidenceID;
        this.crimeType = crimeType;
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

    public boolean isCCTVpresence() {
        return CCTVpresence;
    }

    public void setCCTVpresence(boolean CCTVpresence) {
        this.CCTVpresence = CCTVpresence;
    }

    public String getWeaponUsed() {
        return weaponUsed;
    }

    public void setWeaponUsed(String weaponUsed) {
        this.weaponUsed = weaponUsed;
    }

    public String getInjuryDetail() {
        return injuryDetail;
    }

    public void setInjuryDetail(String injuryDetail) {
        this.injuryDetail = injuryDetail;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
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

    public CrimeType getCrimeType() {
        return crimeType;
    }

    public void setCrimeType(CrimeType crimeType) {
        this.crimeType = crimeType;
    }
    public void displayDetails(){

    }
}

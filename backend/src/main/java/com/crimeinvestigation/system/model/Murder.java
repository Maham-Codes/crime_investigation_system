package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "caseID")
public class Murder extends CrimeCase {

    private LocalDateTime timeOfDeath;
    private String victimName;
    private boolean bodyRecovered;
    private String autopsy;

    public Murder() {
        super();
    }

    public Murder(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                  int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                  String motive, CrimeType crimeType, LocalDateTime timeOfDeath, String victimName,
                  boolean bodyRecovered, String autopsy) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.timeOfDeath = timeOfDeath;
        this.victimName = victimName;
        this.bodyRecovered = bodyRecovered;
        this.autopsy = autopsy;
    }

    // Getters and Setters
    public LocalDateTime getTimeOfDeath() {
        return timeOfDeath;
    }

    public void setTimeOfDeath(LocalDateTime timeOfDeath) {
        this.timeOfDeath = timeOfDeath;
    }

    public String getVictimName() {
        return victimName;
    }

    public void setVictimName(String victimName) {
        this.victimName = victimName;
    }

    public boolean isBodyRecovered() {
        return bodyRecovered;
    }

    public void setBodyRecovered(boolean bodyRecovered) {
        this.bodyRecovered = bodyRecovered;
    }

    public String getAutopsy() {
        return autopsy;
    }

    public void setAutopsy(String autopsy) {
        this.autopsy = autopsy;
    }

    public void causeOfDeath() {
        System.out.println("Cause of death based on autopsy: " + autopsy);
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Time of Death: " + timeOfDeath);
        System.out.println("Victim Name: " + victimName);
        System.out.println("Body Recovered: " + bodyRecovered);
        System.out.println("Autopsy Report: " + autopsy);
    }
}

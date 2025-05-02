package com.crimeinvestigation.system.model;

import java.sql.SQLOutput;
import java.time.LocalDateTime;

public class Murder extends Crime implements CrimeType{
    private LocalDateTime timeOfDeath;
    private String victimName;
    private boolean bodyRecovered;
    private String autopsy;

    public Murder(LocalDateTime timeOfDeath, String victimName, boolean bodyRecovered, String autopsy) {
        super(0, false, null, null, null);
        this.timeOfDeath = timeOfDeath;
        this.victimName = victimName;
        this.bodyRecovered = bodyRecovered;
        this.autopsy = autopsy;
    }

    public Murder(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String CrimeType, LocalDateTime timeOfDeath, String victimName, boolean bodyRecovered, String autopsy) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.timeOfDeath = timeOfDeath;
        this.victimName = victimName;
        this.bodyRecovered = bodyRecovered;
        this.autopsy = autopsy;
    }

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

    public void causeOfDeath(String autopsy){
        System.out.println("The cause of death can be known in detail from the autopsy report which is given in detail below: "+autopsy);
    }

    @Override
    public void displayDetails() {
        System.out.println("Crime ID: " + crimeID);
        System.out.println("CCTV Presence: " + CCTVpresence);
        System.out.println("Weapon Used: " + weaponUsed);
        System.out.println("Injury Detail: " + injuryDetail);
        System.out.println("Motive: " + motive);
        System.out.println("Time: " + timeOfDeath);
        System.out.println("Victim: " + victimName);
        System.out.println("Is body recovered: " + bodyRecovered);
        System.out.println("Autopsy Report: " + autopsy);
    }
}

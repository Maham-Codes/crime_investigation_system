package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public final class LawsAndPunishments {
    @Id
    private  String lawID;
    private  String crimeType;
    private  String sectionName;
    private  String punishment;

    public LawsAndPunishments(String lawID,String crimeType , String sectionName, String punishment) {
        this.lawID = lawID;
        this.sectionName = sectionName;
        this.punishment = punishment;
        this.crimeType = crimeType;
    }

    public LawsAndPunishments(){}

    public String getLawID() {
        return lawID;
    }

    public String getSectionName() {
        return sectionName;
    }

    public String getPunishment() {
        return punishment;
    }

    public String getcrimeType() {
        return crimeType;
    }

    public  void displayDetails() {
        System.out.println("LawID: "+lawID);
        System.out.println("Crime Type: "+crimeType);
        System.out.println("Law: "+sectionName);
        System.out.println("Punishment: "+punishment);
    }
}

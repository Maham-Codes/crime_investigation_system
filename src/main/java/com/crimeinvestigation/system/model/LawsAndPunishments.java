package com.crimeinvestigation.system.model;

public final class LawsAndPunishments {
    private final String lawID;
    private final String crimeType;
    private final String sectionName;
    private final String punishment;

    public LawsAndPunishments(String lawID,String crimeType , String sectionName, String punishment) {
        this.lawID = lawID;
        this.sectionName = sectionName;
        this.punishment = punishment;
        this.crimeType = crimeType;
    }

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

package com.crimeinvestigation.system.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SH_and_Rape extends Harassment {

    protected String relationToHarasser;
    protected String sexualHarassmentType;
    protected boolean rape;
    protected String rapeType;

    public SH_and_Rape() {
        super();
        this.relationToHarasser = null;
        this.sexualHarassmentType = null;
        this.rape = false;
        this.rapeType = null;
    }

    public SH_and_Rape(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                       int userID, int evidenceID, boolean CCTVpresence, String weaponUsed,
                       String injuryDetail, String motive, CrimeType crimeType, String harassmentType,
                       String relationToHarasser, String sexualHarassmentType, boolean rape, String rapeType) {

        super(date, time, location, description, caseStatus,
                userID, evidenceID, CCTVpresence, weaponUsed, injuryDetail,
                motive, crimeType, harassmentType);
        this.relationToHarasser = relationToHarasser;
        this.sexualHarassmentType = sexualHarassmentType;
        this.rape = rape;
        this.rapeType = rapeType;
    }

    public String getRelationToHarasser() {
        return relationToHarasser;
    }

    public void setRelationToHarasser(String relationToHarasser) {
        this.relationToHarasser = relationToHarasser;
    }

    public String getSexualHarassmentType() {
        return sexualHarassmentType;
    }

    public void setSexualHarassmentType(String sexualHarassmentType) {
        this.sexualHarassmentType = sexualHarassmentType;
    }

    public boolean isRape() {
        return rape;
    }

    public void setRape(boolean rape) {
        this.rape = rape;
    }

    public String getRapeType() {
        return rapeType;
    }

    public void setRapeType(String rapeType) {
        this.rapeType = rapeType;
    }

    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to CrimeCase's displayDetails

        System.out.println("Harassment Type: " + harassmentType);
        System.out.println("Sexual Harassment Type: " + sexualHarassmentType);
        System.out.println("Relation to Harasser: " + relationToHarasser);
        System.out.println("Rape: " + (rape ? "Yes" : "No"));
        System.out.println("Rape Type: " + rapeType);
    }
}

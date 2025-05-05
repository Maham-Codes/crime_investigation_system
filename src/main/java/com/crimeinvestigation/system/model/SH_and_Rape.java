package com.crimeinvestigation.system.model;

public class SH_and_Rape extends Harassment {
    protected String relationToHarasser;
    protected String sexualHarassmentType;
    protected boolean rape;
    protected String rapeType;

    public SH_and_Rape(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                       String motive, String crimeType, String harassmentType,
                       String relationToHarasser, String sexualHarassmentType,
                       boolean rape, String rapeType) {

        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive, crimeType, harassmentType);
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
    public String harassmentDetail() {
        return "Sexual Harassment\n----------------\n" +
                "Sexual Harassment Type: " + sexualHarassmentType + ".\n" +
                "Relation to Harasser: " + relationToHarasser + ".\n" +
                "Rape? " + (rape ? "Yes" : "No") + ".\n" +
                "Type of Rape: " + rapeType + ".";
    }
}

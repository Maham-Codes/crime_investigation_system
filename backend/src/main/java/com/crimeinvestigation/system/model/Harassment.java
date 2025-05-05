package com.crimeinvestigation.system.model;

public abstract class Harassment extends Crime {
    protected String harassmentType;

    public Harassment(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String crimeType, String harassmentType) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.harassmentType = harassmentType;
    }

    public abstract String harassmentDetail();
}

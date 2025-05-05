package com.crimeinvestigation.system.model;

public class Theft extends Crime implements CrimeType{
    protected String stolenItemDescription;
    protected String lossAmount;
    protected String crowdDensity;

    public Theft() {
        super(0, false, null, null, null);
        this.stolenItemDescription = null;
        this.lossAmount = null;
        this.crowdDensity = null;
    }

    public Theft(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String CrimeType, String stolenItemDescription, String lossAmount , String crowdDensity) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.stolenItemDescription = stolenItemDescription;
        this.lossAmount = lossAmount;
        this.crowdDensity = crowdDensity;
    }

    public String getStolenItemDescription() {
        return stolenItemDescription;
    }

    public void setStolenItemDescription(String stolenItemDescription) {
        this.stolenItemDescription = stolenItemDescription;
    }

    public String getLossAmount() {
        return lossAmount;
    }

    public void setLossAmount(String lossAmount) {
        this.lossAmount = lossAmount;
    }
    public String getCrowdDensity() {
        return crowdDensity;
    }
    public void setCrowdDensity(String crowdDensity) {
        this.crowdDensity = crowdDensity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Crime ID: " + crimeID);
        System.out.println("CCTV Presence: " + CCTVpresence);
        System.out.println("Weapon Used: " + weaponUsed);
        System.out.println("Injury Detail: " + injuryDetail);
        System.out.println("Motive: " + motive);
        System.out.println("Stolen Item Description: " + stolenItemDescription);
        System.out.println("Loss Amount: " + lossAmount);
        System.out.println("Crowd Density: " + crowdDensity);
    }
}


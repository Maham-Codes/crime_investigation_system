package com.crimeinvestigation.system.model;

public class Theft extends Crime{
    private String stolenItemDescription;
    private String lossAmount;

    public Theft(String stolenItemDescription, String lossAmount) {
        super();
        this.stolenItemDescription = stolenItemDescription;
        this.lossAmount = lossAmount;
    }

    public Theft(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String CrimeType, String stolenItemDescription, String lossAmount) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive, CrimeType);
        this.stolenItemDescription = stolenItemDescription;
        this.lossAmount = lossAmount;
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
}


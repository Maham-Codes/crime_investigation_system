package com.crimeinvestigation.system.model;

public class Abduction extends Crime implements CrimeType{
    protected String relationToVictim;
    protected String demandMade;
    protected String lastSeen;

    public Abduction() {
        super(0, false, null, null, null);
        this.relationToVictim = null;
        this.demandMade = null;
        this.lastSeen = null;
    }

    public Abduction(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String CrimeType, String relationToVictim, String demandMade, String lastSeen) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.relationToVictim = relationToVictim;
        this.demandMade = demandMade;
        this.lastSeen = lastSeen;
    }

    public String getRelationToVictim() {
        return relationToVictim;
    }

    public void setRelationToVictim(String relationToVictim) {
        this.relationToVictim = relationToVictim;
    }

    public String getDemandMade() {
        return demandMade;
    }

    public void setDemandMade(String demandMade) {
        this.demandMade = demandMade;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public void displayDetails(){
        System.out.println("Crime ID: " + crimeID);
        System.out.println("CCTV Presence: " + CCTVpresence);
        System.out.println("Weapon Used: " + weaponUsed);
        System.out.println("Injury Detail: " + injuryDetail);
        System.out.println("Motive: " + motive);
        System.out.println("Relation To Victim: " + relationToVictim);
        System.out.println("Demand Made: " + demandMade);
        System.out.println("Last Seen: " + lastSeen);
    }
}


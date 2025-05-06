package com.crimeinvestigation.system.model;

public class Kidnapping extends Crime implements CrimeType {
    protected String RelationToVictim;
    protected String demandMade;
    protected String lastSeen;
    public Kidnapping() {
        super(0, false, null, null, null);
        RelationToVictim = null;
        demandMade = null;
        lastSeen = null;
    }
    public Kidnapping(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive,String RelationToVictim, String demandMade, String lastSeen) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.RelationToVictim = RelationToVictim;
        this.demandMade = demandMade;
        this.lastSeen = lastSeen;
    }
    public String getRelationToVictim() {
        return RelationToVictim;
    }
    public void setRelationToVictim(String relationToVictim) {
        RelationToVictim = relationToVictim;
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
        System.out.println("Relation To Victim: " + RelationToVictim);
        System.out.println("Demand Made: " + demandMade);
        System.out.println("Last Seen: " + lastSeen);
    }

}

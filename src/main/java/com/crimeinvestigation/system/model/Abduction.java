package com.crimeinvestigation.system.model;

public class Abduction extends Crime {
    protected String relationToVictim;
    protected String demandMade;
    protected String lastSeen;

    public Abduction(String relationToVictim, String demandMade, String lastSeen) {
        super();
        this.relationToVictim = relationToVictim;
        this.demandMade = demandMade;
        this.lastSeen = lastSeen;
    }

    public Abduction(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail, String motive, String CrimeType, String relationToVictim, String demandMade, String lastSeen) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive, CrimeType);
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
}


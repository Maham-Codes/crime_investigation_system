package com.crimeinvestigation.system.model;

public class CyberCrime extends Crime{
    private String platform;
    private boolean threatsInvolved;
    private String offenderAccountId;

    public CyberCrime(String platform, boolean threatsInvolved, String offenderAccountId) {
        super();
        this.platform = platform;
        this.threatsInvolved = threatsInvolved;
        this.offenderAccountId = offenderAccountId;
    }

    public CyberCrime(int crimeID,boolean CCTVpresence,String weaponUsed, String injuryDetail,String CrimeType,String motive,String platform, boolean threatsInvolved, String offenderAccountId) {
        super(crimeID,CCTVpresence,weaponUsed,injuryDetail,motive,CrimeType);
        this.platform = platform;
        this.threatsInvolved = threatsInvolved;
        this.offenderAccountId = offenderAccountId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public boolean isThreatsInvolved() {
        return threatsInvolved;
    }

    public void setThreatsInvolved(boolean threatsInvolved) {
        this.threatsInvolved = threatsInvolved;
    }

    public String getOffenderAccountId() {
        return offenderAccountId;
    }

    public void setOffenderAccountId(String offenderAccountId) {
        this.offenderAccountId = offenderAccountId;
    }
}


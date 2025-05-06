package com.crimeinvestigation.system.model;

public class CyberCrime extends Crime implements CrimeType {

    public enum CyberType {
        PHISHING,
        HACKING,
        MALWARE,
        DATA_BREACH,
        IDENTITY_THEFT
    }

    protected CyberType cyberType;
    protected String platform;
    protected boolean threatsInvolved;
    protected String offenderAccountId;

    public CyberCrime() {
        super(0, false, null, null, null);
        this.cyberType = null;
        this.platform = null;
        this.threatsInvolved = false;
        this.offenderAccountId = null;
    }

    public CyberCrime(int crimeID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                      String motive, CyberType cyberType, String platform,
                      boolean threatsInvolved, String offenderAccountId) {
        super(crimeID, CCTVpresence, weaponUsed, injuryDetail, motive);
        this.cyberType = cyberType;
        this.platform = platform;
        this.threatsInvolved = threatsInvolved;
        this.offenderAccountId = offenderAccountId;
    }

    public CyberType getCyberType() {
        return cyberType;
    }

    public void setCyberType(CyberType cyberType) {
        this.cyberType = cyberType;
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

    @Override
    public void displayDetails() {
        System.out.println("Crime ID: " + crimeID);
        System.out.println("CCTV Presence: " + CCTVpresence);
        System.out.println("Weapon Used: " + weaponUsed);
        System.out.println("Injury Detail: " + injuryDetail);
        System.out.println("Motive: " + motive);
        System.out.println("Cyber Type: " + cyberType);
        System.out.println("Platform: " + platform);
        System.out.println("Threats Involved: " + threatsInvolved);
        System.out.println("Offender Account ID: " + offenderAccountId);
    }
}


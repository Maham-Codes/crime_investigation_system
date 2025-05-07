package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "caseID")
public class CyberCrime extends CrimeCase {

    public enum CyberType {
        PHISHING,
        HACKING,
        MALWARE,
        DATA_BREACH,
        IDENTITY_THEFT
    }

    @Enumerated(EnumType.STRING)
    private CyberType cyberType;
    private String platform;
    private boolean threatsInvolved;
    private String offenderAccountId;

    public CyberCrime() {
        super();
    }

    public CyberCrime(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                      int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                      String motive, CrimeType crimeType, CyberType cyberType, String platform,
                      boolean threatsInvolved, String offenderAccountId) {
        super (date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.cyberType = cyberType;
        this.platform = platform;
        this.threatsInvolved = threatsInvolved;
        this.offenderAccountId = offenderAccountId;
    }

    // Getters and setters
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
        super.displayDetails();
        System.out.println("Cyber Type: " + cyberType);
        System.out.println("Platform: " + platform);
        System.out.println("Threats Involved: " + threatsInvolved);
        System.out.println("Offender Account ID: " + offenderAccountId);
    }
}

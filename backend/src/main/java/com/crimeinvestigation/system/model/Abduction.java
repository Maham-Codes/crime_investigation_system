package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@PrimaryKeyJoinColumn(name = "caseID")
public class Abduction extends CrimeCase {

    private String relationToVictim;
    private String demandMade;
    private String lastSeen;
   public Abduction(){}
    public Abduction(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                     int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                     String motive, CrimeType crimeType, String relationToVictim, String demandMade, String lastSeen) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.relationToVictim = relationToVictim;
        this.demandMade = demandMade;
        this.lastSeen = lastSeen;
    }
    public Abduction(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                     int userID, int evidenceID, boolean CCTVpresence, String weaponUsed, String injuryDetail,
                     String motive, CrimeType crimeType) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
    }

    // Getters and setters
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
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Relation To Victim: " + relationToVictim);
        System.out.println("Demand Made: " + demandMade);
        System.out.println("Last Seen: " + lastSeen);
    }
}

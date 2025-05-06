package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Harassment extends CrimeCase {

    protected String harassmentType;

    public Harassment() {
        super();
    }

    public Harassment(LocalDate date, LocalDateTime time, String location, String description, String caseStatus,
                      int userID, int evidenceID, boolean CCTVpresence, String weaponUsed,
                      String injuryDetail, String motive, CrimeType crimeType, String harassmentType) {
        super(date, time, location, description, caseStatus,
                CCTVpresence, weaponUsed, injuryDetail, motive,
                userID, evidenceID, crimeType);
        this.harassmentType = harassmentType;
    }

    public String getHarassmentType() {
        return harassmentType;
    }

    public void setHarassmentType(String harassmentType) {
        this.harassmentType = harassmentType;
    }


}

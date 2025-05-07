package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "kidnapping")
@PrimaryKeyJoinColumn(name = "caseID")
public class Kidnapping extends CrimeCase {

    private String relationToVictim;
    private String demandMade;
    private String lastSeen;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Relation To Victim: " + relationToVictim);
        System.out.println("Demand Made: " + demandMade);
        System.out.println("Last Seen: " + lastSeen);
    }
}

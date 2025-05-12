package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Kidnapping")
public class Kidnapping extends CrimeCase {

    //@Column(name = "relation_to_victim")
    private String relationToVictim;

    //@Column(name = "demand_made")
    private String demandMade;

    //@Column(name = "last_seen")
    private String lastSeen;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Relation To Victim: " + relationToVictim);
        System.out.println("Demand Made: " + demandMade);
        System.out.println("Last Seen: " + lastSeen);
    }
}

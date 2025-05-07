package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "theft")
@PrimaryKeyJoinColumn(name = "caseID")
public class Theft extends CrimeCase {

    private String stolenItemDescription;
    private double lossAmount;
    private boolean CCTVPresence;
    private int crowdDensity;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Stolen Item Description: " + stolenItemDescription);
        System.out.println("Loss Amount: " + lossAmount);
        System.out.println("CCTV Presence: " + CCTVPresence);
        System.out.println("Crowd Density: " + crowdDensity);
    }
}

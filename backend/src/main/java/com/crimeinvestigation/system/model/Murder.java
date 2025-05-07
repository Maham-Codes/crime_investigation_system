package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "murder")
@PrimaryKeyJoinColumn(name = "caseID")
public class Murder extends CrimeCase {

    private LocalTime timeOfDeath;
    private String victimName;
    private boolean bodyRecovered;
    private String autopsy;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Time of Death: " + timeOfDeath);
        System.out.println("Victim Name: " + victimName);
        System.out.println("Body Recovered: " + bodyRecovered);
        System.out.println("Autopsy Report: " + autopsy);
    }
}

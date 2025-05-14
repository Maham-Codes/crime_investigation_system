package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("murder")
public class Murder extends CrimeCase {

    //@Column(name = "time_of_death")
    private LocalTime timeOfDeath;

    //@Column(name = "victim_name")
    private String victimName;

    //@Column(name = "body_recovered")
    private Boolean bodyRecovered;

    //@Column(name = "autopsy")
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

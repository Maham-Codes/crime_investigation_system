package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Theft")
public class Theft extends CrimeCase {

    //@Column(name = "stolen_item_description")
    private String stolenItemDescription;

    //@Column(name = "loss_amount")
    private double lossAmount;

    //@Column(name = "cctv_presence")
    private boolean CCTVPresence;

    //@Column(name = "crowd_density")
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

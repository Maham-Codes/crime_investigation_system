package com.crimeinvestigation.system.model;


import com.crimeinvestigation.system.enums.CyberType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CyberCrime")
public class CyberCrime extends CrimeCase {


    @Enumerated(EnumType.STRING)
    //@Column(name = "cyber_type")
    private CyberType cyberType;

    //@Column(name = "affected_platform")
    private String affectedPlatform;

    //@Column(name = "target_system")
    private String targetSystem;

    //@Column(name = "files_accessed")
    private String filesAccessed;

    //@Column(name = "number_of_incidents")
    private int numberOfIncidents;

    //@Column(name = "amount_lost")
    private double amountLost;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Cyber Type: " + cyberType);
        System.out.println("Platform: " + affectedPlatform);
        System.out.println("Target System: " + targetSystem);
        System.out.println("Files Accessed: " + filesAccessed);
        System.out.println("Number Incidents: " + numberOfIncidents);
        System.out.println("Amount Lost: " + amountLost);
    }
}

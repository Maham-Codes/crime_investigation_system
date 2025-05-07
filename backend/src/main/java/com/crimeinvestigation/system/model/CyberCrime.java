package com.crimeinvestigation.system.model;


import com.crimeinvestigation.system.enums.CyberType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "caseID")
public class CyberCrime extends CrimeCase {


    @Enumerated(EnumType.STRING)
    private CyberType cyberType;

    private String affectedPlatform;
    private String targetSystem;
    private String filesAccessed;
    private int numberOfIncidents;
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

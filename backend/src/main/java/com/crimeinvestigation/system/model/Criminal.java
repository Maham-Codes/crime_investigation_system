package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.CrimeType;
import jakarta.persistence.*;
import java.util.Set;
import lombok.*;


@Entity
@Table(name = "criminal")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "personID")
public class Criminal extends Person {

    @ManyToMany
    @JoinTable(
            name = "crime_case_criminal", // Join table that will be auto-created
            joinColumns = @JoinColumn(name = "criminal_id", referencedColumnName = "personid"), // uses id from Criminal (inherited from Person)
            inverseJoinColumns = @JoinColumn(name = "case_id") // uses id from CrimeCase
    )
    private Set<CrimeCase> cases;


    @Enumerated(EnumType.STRING)
    private CrimeType crimeType;
    protected String currentStatus;
     protected String reputation;
     protected String nationality;

     @Override
     public void displayDetails(){
         super.displayDetails();
         System.out.println("Crime Type: "+crimeType);
         System.out.println("Reputation: "+reputation);
         System.out.println("Nationality: "+nationality);
         System.out.println("Status: "+currentStatus);
     }
}


package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.Crimetypes;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("Criminal")
public class Criminal extends Person {

    /*@ManyToMany
    @JoinTable(
            name = "crime_case_criminal", // Join table that will be auto-created
            joinColumns = @JoinColumn(name = "criminal_id", referencedColumnName = "personid"), // uses id from Criminal (inherited from Person)
            inverseJoinColumns = @JoinColumn(name = "case_id") // uses id from CrimeCase
    )
    private Set<CrimeCase> cases;*/


    @Enumerated(EnumType.STRING)
    private Crimetypes crimetypes;
    protected String currentStatus;
    protected String reputation;
    protected String nationality;

     @Override
     public void displayDetails(){
         super.displayDetails();
         System.out.println("Crime Type: "+ crimetypes);
         System.out.println("Reputation: "+reputation);
         System.out.println("Nationality: "+nationality);
         System.out.println("Status: "+currentStatus);
     }
}


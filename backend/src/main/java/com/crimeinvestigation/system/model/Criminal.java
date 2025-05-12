package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.enums.Crimetypes;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("criminal")
public class Criminal extends Person {
    /*@ManyToMany
    @JoinTable(
            crimeName = "crime_case_criminal", // Join table that will be auto-created
            joinColumns = @JoinColumn(crimeName = "criminal_id", referencedColumnName = "personid"), // uses id from Criminal (inherited from Person)
            inverseJoinColumns = @JoinColumn(crimeName = "case_id") // uses id from CrimeCase
    )
    private Set<CrimeCase> cases;*/


    @Enumerated(EnumType.STRING)
    @Column(name = "crime_type")
    private Crimetypes crimetypes;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private CaseStatus currentStatus;

    @Column(name = "reputation")
    protected String reputation;

    @Column(name = "nationality")
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


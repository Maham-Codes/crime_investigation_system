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
public class Criminal extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int criminalID;

    @ManyToMany
    @JoinTable(
            name = "crime_case_criminal",  // Join table name
            joinColumns = @JoinColumn(name = "criminalID"),  // Foreign key referring to Criminal
            inverseJoinColumns = @JoinColumn(name = "caseID")  // Foreign key referring to CrimeCase
    )
    @Getter
    @Setter
    private Set<CrimeCase> cases;


    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private CrimeType crimeType;
    protected String currentStatus;
     protected String reputation;
     protected String nationality;
}


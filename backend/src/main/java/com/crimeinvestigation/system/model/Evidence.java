package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "evidence")
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int evidenceID;

    /*@ManyToOne
    @JoinColumn(name = "userID")
    private User userID;*/

    /*@ManyToOne
    @JoinColumn(name = "caseID")
    private CrimeCase caseID;*/

    private String evidenceType;

    public void displayDetails() {
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Evidence Type: " + evidenceType);
    }
}


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
    @Column(name = "evidence_id")
    private Long evidenceID;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private CrimeCase crimeCase;

    @Column(name = "evidence_type")
    private String evidenceType;

    public void displayDetails() {
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Evidence Type: " + evidenceType);
    }
}


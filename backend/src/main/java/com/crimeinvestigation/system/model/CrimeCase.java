package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crime_case")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CrimeCase {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "caseID")
    private int caseID;
    protected LocalDateTime date_time;
    protected String location;
    protected String description;

    @ManyToOne
    @JoinColumn(name = "typeID")
    protected User userID;

    protected int evidenceID;

    @ManyToOne
    @JoinColumn(name = "typeID")
    private CrimeType typeID;

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @ManyToOne
    private Investigator assignedInvestigator;

    @OneToOne
    @JoinColumn(name = "investigatorID")
    private Investigator investigatorID;

    public void displayDetails() {}
}

package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "crime_case")
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
    @Setter
    @Getter
    protected User userID;

    protected int evidenceID;

    @ManyToOne
    @JoinColumn(name = "typeID")
    @Setter
    @Getter
    private CrimeType typeID;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private CaseStatus caseStatus;

    @ManyToOne
    @Setter
    @Getter
    private Investigator assignedInvestigator;

    @OneToOne
    @JoinColumn(name = "investigatorID")
    @Setter
    @Getter
    private Investigator investigatorID;

    public void displayDetails() {}
}

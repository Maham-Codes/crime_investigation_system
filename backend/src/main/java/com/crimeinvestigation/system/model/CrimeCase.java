package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "crime_case")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public abstract class CrimeCase {

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

    @ManyToMany(mappedBy = "cases")
    private Set<Criminal> criminals;

    @OneToOne
    @JoinColumn(name = "investigatorID")
    private Investigator investigatorID;

    public void displayDetails() {}
}

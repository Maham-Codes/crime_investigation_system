package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crime_case")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(crimeName = "case_type", discriminatorType = DiscriminatorType.STRING)
public class CrimeCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    protected Long caseID;
    @Column(name = "date_time")
    protected LocalDateTime dateTime;
    @Column(name = "location")
    protected String location;
    @Column(name = "description")
    protected String description;

    /*@ManyToOne
    @JoinColumn(crimeName = "typeID")
    protected User userID;*/

    //protected int evidenceID;

    @ManyToOne
    @JoinColumn(name = "crime_type_id")
    private CrimeType crimeType;

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @OneToOne
    @JoinColumn(name = "investigator_id")
    private Investigator investigatorID;

    private Investigator assignedInvestigator;


    public void displayDetails() {}
}

package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "crime_case")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "case_type", discriminatorType = DiscriminatorType.STRING)
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
    @Column(name = "cctv_presence")
    private Boolean CCTVPresence;

    // Aggregation: One crime case can have multiple evidence entries
    @OneToMany(mappedBy = "crimeCase", cascade = CascadeType.ALL)
    private List<Evidence> evidenceList;

    @ManyToOne
    @JoinColumn(name = "crime_type_id")
    private CrimeType crimeType;

    @Enumerated(EnumType.STRING)
    private CaseStatus caseStatus;

    @OneToOne
    @JoinColumn(name = "investigator_id")
    private Investigator investigatorID;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reportedBy;


    public void displayDetails() {}

    //PLSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
}

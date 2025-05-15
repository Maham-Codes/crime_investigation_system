package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.*;
import jakarta.persistence.*;
import lombok.*; // Make sure you have Lombok and these annotations are working
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor // Lombok
@NoArgsConstructor  // Lombok
@Table(name = "crime_case")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "case_type", discriminatorType = DiscriminatorType.STRING)
public class CrimeCase { // Make it non-abstract if you want to persist base CrimeCase instances
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "case_id")
    protected Long caseID;

    @Column(name = "date_time")
    protected LocalDateTime dateTime;

    @Column(name = "location")
    protected String location;

    @Column(name = "description", columnDefinition = "TEXT") // Use TEXT for longer descriptions
    protected String description;

    @Column(name = "cctv_presence")
    private Boolean CCTVPresence; // Field from your DTO

    @ManyToOne(fetch = FetchType.LAZY) // Good practice for performance
    @JoinColumn(name = "crime_type_id"/*, nullable = false*/) // Ensure this column exists in your DB
    // Add nullable = false if a CrimeType is mandatory
    private CrimeType crimeType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Case status is likely mandatory
    private CaseStatus caseStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id"/*, nullable = false*/) // This is the 'reportedBy' user.
    // Add nullable = false if reporter is mandatory
    private User reportedBy;

    @ManyToOne(fetch = FetchType.LAZY) // Changed from @OneToOne if one investigator can have many cases
    @JoinColumn(name = "investigator_id", nullable = true) // Investigator can be assigned later
    private Investigator investigatorID; // Changed name to investigator

    // Relationships (keep if they are correct)
    @OneToMany(mappedBy = "crimeCase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evidence> evidenceList;

    @OneToMany(mappedBy = "caseID", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrackingStatus> trackingStatuses;

    public void displayDetails() {

    }

    // --- Fields for subclasses (if you create specific crime type entities later) ---
    // e.g., for a 'Theft' subclass:
    // @Column(name = "stolen_item_description")
    // private String stolenItemDescription; // This would be in a Theft.java that extends CrimeCase
}
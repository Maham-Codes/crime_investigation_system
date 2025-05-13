package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracking_status")
public class TrackingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tracking_id")
    private Long trackingID;
    @ManyToOne
    @JoinColumn(name = "case_id", referencedColumnName = "case_id")
    private CrimeCase caseID;

    @Enumerated(EnumType.STRING)
    @Column(name = "update_status")
    private CaseStatus updatedStatus;



    public void updateStatus(CaseStatus newStatus) {
        this.updatedStatus = newStatus;
    }

}

package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.enums.CaseStatus;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tracking_status")
public class TrackingStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trackingID;
    @ManyToOne
    @JoinColumn(name = "caseID", referencedColumnName = "caseID")
    private CrimeCase caseID;

    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private CaseStatus updateStatus;

    public void displayStatus() {
        System.out.println("Tracking ID: " + trackingID);
        System.out.println("Case ID: " + caseID);
        System.out.println("Status: " + updateStatus);
    }
    /*public void updateStatus(String newStatus, String comments) {
        this.updateSatus = newStatus;
        this.updateDate = LocalDate.now(); // Automatically update the date when caseStatus is changed
    }*/

}

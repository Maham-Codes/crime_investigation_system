package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "harassment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "caseID")
public class Harassment extends CrimeCase {

    protected String harassmentType;
    protected String placeType;
    protected String languageUsed;
    protected boolean threatsInvolved;
    protected String relationToHarasser;
}

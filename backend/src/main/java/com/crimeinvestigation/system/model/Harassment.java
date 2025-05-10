package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Harassment")
public class Harassment extends CrimeCase {

    protected String harassmentType;
    protected String placeType;
    protected String languageUsed;
    protected boolean threatsInvolved;
    protected String relationToHarasser;
}

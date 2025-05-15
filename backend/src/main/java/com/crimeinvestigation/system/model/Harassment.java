package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("harassment")
public class Harassment extends CrimeCase {

    //@Column(name = "harassment_type")
    protected String harassmentType;

    //@Column(name = "place_type")
    protected String placeType;

    //@Column(name = "language_used")
    protected String languageUsed;

    //@Column(name = "threats_invovled")
    protected Boolean threatsInvolved;

    //@Column(name = "relation_to_harasser")
    protected String relationToHarasser;
}

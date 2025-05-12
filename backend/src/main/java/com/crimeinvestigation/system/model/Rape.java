package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Rape")
public class Rape extends Harassment {

    @Column(name = "date_time")
    protected LocalDateTime dateTime;

    //@Column(name = "rape_type")
    protected String rapeType;



    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to CrimeCase's displayDetails
        System.out.println("Rape Type: " + rapeType);
        System.out.println("Date Time: " + dateTime);
    }
}

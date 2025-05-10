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
public class SH_and_Rape extends Harassment {
    protected LocalDateTime Date_Time;
    protected String rapeType;



    @Override
    public void displayDetails() {
        super.displayDetails(); // Call to CrimeCase's displayDetails
        System.out.println("Rape Type: " + rapeType);
        System.out.println("Date Time: " + Date_Time);
    }
}

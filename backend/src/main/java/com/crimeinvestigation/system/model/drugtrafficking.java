package com.crimeinvestigation.system.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("drugtrafficking")
public class drugtrafficking extends CrimeCase{
    private String drugType;
    private String quantity;
    private String storageMethod;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Drug Type: " + drugType);
        System.out.println("Quantity: " + quantity);
        System.out.println("Storage Method: " + storageMethod);
    }
}

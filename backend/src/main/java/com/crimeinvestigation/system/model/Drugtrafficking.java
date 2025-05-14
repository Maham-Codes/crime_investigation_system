package com.crimeinvestigation.system.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("drugtrafficking")
public class Drugtrafficking extends CrimeCase{
    //@Column(name = "drug_type")
    private String drugType;

    //@Column(name = "quantity")
    private String quantity;

    //@Column(name = "storage_method")
    private String storageMethod;


    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Drug Type: " + drugType);
        System.out.println("Quantity: " + quantity);
        System.out.println("Storage Method: " + storageMethod);
    }
}

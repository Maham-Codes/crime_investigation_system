package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "laws_and_punishments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LawsAndPunishments {
    @Id
    private  String lawID;
    private  String crime_type;
    private  String section_name;
    private  String punishment;


    public  void displayDetails() {
        System.out.println("LawID: "+lawID);
        System.out.println("Crime Type: "+crime_type);
        System.out.println("Law: "+section_name);
        System.out.println("Punishment: "+punishment);
    }
}

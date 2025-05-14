package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.interfaces.Displayable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "laws_and_punishments")
public class LawsAndPunishments implements Displayable {
    @Id
    @Column(name = "law_id")
    private  Long lawID;

    @ManyToOne
    @JoinColumn(name = "crime_type_id")  // this matches your table FK// Assuming you have a CrimeType entity
    private  CrimeType crimeType;

    @Column(name = "section_name")
    private  String section_name;

    @Column(name = "punishment")
    private  String punishment;

    public LawsAndPunishments(long lawID, String robbery, String sectionName, String punishment) {
    }


    @Override
    public  void display() {
        System.out.println("LawID: "+lawID);
        System.out.println("Crime Type: "+ crimeType);
        System.out.println("Law: "+section_name);
        System.out.println("Punishment: "+punishment);
    }
}

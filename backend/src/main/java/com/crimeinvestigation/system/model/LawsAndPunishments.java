package com.crimeinvestigation.system.model;

import com.crimeinvestigation.system.interfaces.Displayable;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "laws_and_punishments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LawsAndPunishments implements Displayable {
    @Id
    @Column(name = "law_id")
    private  Long lawID;

    //@Column(name = "crime_type")
    private  String crime_type;

    @Column(name = "section_name")
    private  String section_name;

    @Column(name = "punishment")
    private  String punishment;


    @Override
    public  void display() {
        System.out.println("LawID: "+lawID);
        System.out.println("Crime Type: "+crime_type);
        System.out.println("Law: "+section_name);
        System.out.println("Punishment: "+punishment);
    }
}

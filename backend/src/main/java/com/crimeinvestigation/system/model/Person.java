package com.crimeinvestigation.system.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "person")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int personid;

    protected String name;
    protected String father_name;
    protected String contact_number;
    protected String dob;
    protected String occupation;
    protected String cnic;
    protected String gender;


    public int getAge() {
        try {
            LocalDate dob = LocalDate.parse(getDob());
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        } catch (Exception e) {
            System.out.println("Invalid date format in DOB. Expected format: yyyy-MM-dd");
            return 0;
        }
    }

    public void displayDetails(){
        System.out.println("Name: " + getName());
        System.out.println("Father: " + getFather_name());
        System.out.println("Contact: " + getContact_number());
        System.out.println("Occupation: " + getOccupation());
        System.out.println("Birthday: " + getDob());
        System.out.println("Gender: " + getGender());
    }
}
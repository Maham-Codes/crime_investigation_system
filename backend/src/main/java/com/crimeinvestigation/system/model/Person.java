package com.crimeinvestigation.system.model;
import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.enums.Role;
import jakarta.persistence.*;
import lombok.*;



import java.time.LocalDate;
import java.time.Period;


@Table(name = "person")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)// Use SINGLE_TABLE for Person hierarchy
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    protected Long personid;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "mid_name")
    protected String midName;

    @Column(name = "last_name")
    protected String lastName;

    @Column(name = "father_name")
    protected String father_name;

    @Column(name = "contact_number")
    protected String contact_number;

    @Column(name = "dob")
    protected LocalDate dob;

    @Column(name = "occupation")
    protected String occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "cnic")
    protected String cnic;

    @Column(name = "gender")
    protected String gender;


    /*public int getAge() {
        try {
            LocalDate dob = LocalDate.parse(getDob());
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        } catch (Exception e) {
            System.out.println("Invalid date format in DOB. Expected format: yyyy-MM-dd");
            return 0;
        }
    }*/




    public void displayDetails(){
        System.out.println("Name: " + getFirstName());
        System.out.println("MID: " + getMidName());
        System.out.println("Last Name: " + getLastName());
        System.out.println("Father: " + getFather_name());
        System.out.println("Contact: " + getContact_number());
        System.out.println("Occupation: " + getOccupation());
        System.out.println("Birthday: " + getDob());
        System.out.println("Gender: " + getGender());
    }
}
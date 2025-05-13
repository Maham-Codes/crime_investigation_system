package com.crimeinvestigation.system.model;
import com.crimeinvestigation.system.enums.Gender;
import com.crimeinvestigation.system.enums.Role;
import com.crimeinvestigation.system.exception.IllegalArgumentException;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)// Use SINGLE_TABLE for Person hierarchy
public abstract class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "mid_name")
    private String midName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "father_name")
    private String fatherName;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "occupation")
    private String occupation;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Column(name = "cnic")
    private String cnic;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

//utility method
    public int getAge() {
        try {
            LocalDate dateOfBirth = this.dob; // Use the class field directly
            if (dateOfBirth == null) {
                return 0;
            }
            LocalDate today = LocalDate.now();
            return Period.between(dateOfBirth, today).getYears();
        } catch (Exception e) {
            System.out.println("Error calculating age");
            return 0;
        }
    }

    public void setCnic(String cnic) {
        if (!cnic.matches("\\d{13}")) {
            throw new IllegalArgumentException("Invalid CNIC");
        }
        this.cnic = cnic;
    }

    public abstract void displayDetails();
}
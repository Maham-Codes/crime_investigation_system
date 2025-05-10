package com.crimeinvestigation.system.model;
import com.crimeinvestigation.system.enums.Crimetypes;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Investigator")
public class Investigator extends Person {
    protected String band;

    protected String workTiming;
    protected int no_of_current_cases;
    protected int solved_cases;
    private String role = "INVESTIGATOR";

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Crimetypes specialization;

    private String password;

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: " + role);
        System.out.println("Email: " + email);
        System.out.println("Specialization: " + specialization);
        System.out.println("No of Current Cases: " + no_of_current_cases);
        System.out.println("Solved Cases: " + solved_cases);
        System.out.println("Work Timing: " + workTiming);
        System.out.println("No of Current Cases: " + no_of_current_cases);
        System.out.println("Solved Cases: " + solved_cases);
    }
}

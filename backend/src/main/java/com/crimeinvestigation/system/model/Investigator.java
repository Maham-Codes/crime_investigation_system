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
    //@Column(name = "band")
    protected String band;

    //@Column(name = "work_timing")
    protected String workTiming;

    //@Column(name = "no_of_current_cases")
    protected int no_of_current_cases;

    //@Column(name = "solved_cases")
    protected int solved_cases;


    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Crimetypes specialization;

    private String password;

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Email: " + email);
        System.out.println("Specialization: " + specialization);
        System.out.println("No of Current Cases: " + no_of_current_cases);
        System.out.println("Solved Cases: " + solved_cases);
        System.out.println("Work Timing: " + workTiming);
        System.out.println("No of Current Cases: " + no_of_current_cases);
        System.out.println("Solved Cases: " + solved_cases);
    }
}

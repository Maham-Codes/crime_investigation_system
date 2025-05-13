package com.crimeinvestigation.system.model;
import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.interfaces.SensitiveData;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("Investigator")
public class Investigator extends Person implements SensitiveData {
    //@Column(name = "band")
    protected String band;

    //@Column(name = "work_timing")
    protected String workTiming;

    //@Column(name = "no_of_current_cases")
    protected int noOfCurrentCases;

    //@Column(name = "solved_cases")
    protected int solvedCases;


    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Crimetypes specialization;

    private String password;

    @Override
    public void displayDetails(){
        System.out.println("Email: " + email);
        System.out.println("Specialization: " + specialization);
        System.out.println("No of Current Cases: " + noOfCurrentCases);
        System.out.println("Solved Cases: " + solvedCases);
        System.out.println("Work Timing: " + workTiming);
    }
}

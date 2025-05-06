package com.crimeinvestigation.system.model;
import com.crimeinvestigation.system.enums.CrimeType;
import jakarta.persistence.*;


@Entity
public class Investigator extends Person {
    protected String band;
    protected int NoOfCurrentCases;
    protected int solvedCases;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private CrimeType specialization;

    private String password;

    public Investigator(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String rank,int NoOfCurrentCases,int solvedCases)
    {
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
this.band =rank;
this.NoOfCurrentCases=NoOfCurrentCases;
this.solvedCases=solvedCases;
    }

    public Investigator(){}

    public void setBand(String band){ this.band = band;}
    public String getBand(){ return band;}
    public void setNoOfCurrentCases(int NoOfCurrentCases){ this.NoOfCurrentCases=NoOfCurrentCases;}
    public int getNoOfCurrentCases(){ return NoOfCurrentCases;}
    public void setSolvedCases(int solvedCases){ this.solvedCases=solvedCases;}
    public int getSolvedCases(){ return solvedCases;}
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public CrimeType getSpecialization() { return specialization; }
    public void setSpecialization(CrimeType specialization) { this.specialization = specialization; }

}

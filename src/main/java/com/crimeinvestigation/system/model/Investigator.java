package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
public class Investigator extends Person {

    protected String band;
    protected int NoOfCurrentCases;
    protected int solvedCases;

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

}

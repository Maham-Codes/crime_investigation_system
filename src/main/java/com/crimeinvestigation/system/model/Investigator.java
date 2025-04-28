package com.crimeinvestigation.system.model;

public class Investigator extends Person {
    protected String rank;
    protected int NoOfCurrentCases;
    protected int solvedCases;

    Investigator(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String rank,int NoOfCurrentCases,int solvedCases)
    {
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
this.rank=rank;
this.NoOfCurrentCases=NoOfCurrentCases;
this.solvedCases=solvedCases;
    }

}

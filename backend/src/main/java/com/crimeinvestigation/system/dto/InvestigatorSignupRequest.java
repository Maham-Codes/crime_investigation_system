package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.CrimeType;
import com.crimeinvestigation.system.enums.Gender;


public class InvestigatorSignupRequest {
    public String name;
    public String fatherName;
    public String contactNumber;
    public String dob;
    public String occupation;
    public String cnic;
    public int personId;
    public Gender inv_gender;
    public String rank;
    public int noOfCurrentCases;
    public int solvedCases;
    public String email;
    public String password;
    public CrimeType specialization;
}

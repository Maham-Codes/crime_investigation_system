package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.Crimetypes;
import com.crimeinvestigation.system.enums.Gender;
import com.crimeinvestigation.system.enums.Role;


public class InvestigatorSignupRequest {
    public String firstName;
    public String midName;
    public String lastName;
    public String fatherName;
    public String contactNumber;
    public String dob;
    public String occupation;
    public String cnic;
    public int personId;
    public Gender gender;
    public Role role;
    public String rank;
    public int noOfCurrentCases;
    public int solvedCases;
    public String email;
    public String password;
    public Crimetypes specialization;
}

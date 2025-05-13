package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.Role;
import com.crimeinvestigation.system.enums.Gender;

public class UserSignupRequest {
    public String firstName;
    public String midName;
    public String lastName;
    public String fatherName;
    public String contactNumber;
    public String dob;
    public String occupation;
    public String cnic;
    public int personId;
    public String address;
    public Gender gender;
    public String email;
    public String password;
    public Role role;  // VICTIM or EYEWITNESS
}
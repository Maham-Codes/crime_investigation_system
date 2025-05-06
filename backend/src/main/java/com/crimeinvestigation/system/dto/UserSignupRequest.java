package com.crimeinvestigation.system.dto;

import com.crimeinvestigation.system.enums.Role;
import com.crimeinvestigation.system.enums.Gender;

public class UserSignupRequest {
    public String fullName;
    public String fatherName;
    public String contactNumber;
    public String dob;
    public String occupation;
    public String CNICNumber;
    public int personId;
    public  Gender user_gender;
    public String email;
    public String password;
    public Role role;  // VICTIM or EYEWITNESS
}
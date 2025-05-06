package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import com.crimeinvestigation.system.enums.Role;
import jakarta.persistence.*;


@Entity
public class User extends Person{
    public enum UserType {
        Victim,
        Eyewtiness
    }
    protected String Address;

    @Column(unique = true)
    private String email;

    private String password;
    protected UserType UserType;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {}

    User(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String Address,
         String email,UserType UserType){
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
        this.Address=Address;
        this.email=email;
        this.UserType=UserType;

    }
    public void setAddress(String Address){this.Address=Address;}
    public String getAddress() {return Address;}
    public void setEmail(String email){this.email=email;}
    public String getEmail() {return email;}
    public void setUserType(UserType UserType){this.UserType=UserType;}
    public UserType getUserType() {return UserType;}


    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }

}

package com.crimeinvestigation.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends Person{
    public enum UserType {
        Victim,
        Eyewtiness
    }
    protected String Address;
    protected String email;
    protected UserType UserType;


    public User(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String Address,
         String email,UserType UserType){
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
        this.Address=Address;
        this.email=email;
        this.UserType=UserType;

    }

    public User(){}
    public void setAddress(String Address){this.Address=Address;}
    public String getAddress() {return Address;}
    public void setEmail(String email){this.email=email;}
    public String getEmail() {return email;}
    public void setUserType(UserType UserType){this.UserType=UserType;}
    public UserType getUserType() {return UserType;}

    public void displayDetails(){
        System.out.println("Name: "+getName());
        System.out.println("Type: "+getUserType());
        System.out.println("Address: "+getAddress());
        System.out.println("Email: "+getEmail());
        System.out.println("FatherName: "+getFatherName());
        System.out.println("ContactNumber: "+getContactNumber());
        System.out.println("DOB: "+getDOB());
        System.out.println("Occupation: "+getOccupation());
        System.out.println("CNIC: "+getCNIC());
        System.out.println("PersonID: "+getPersonID());
        System.out.println("Gender: "+getGender());
        System.out.println("Address: "+getAddress());
        System.out.println("Email: "+getEmail());
    }
}

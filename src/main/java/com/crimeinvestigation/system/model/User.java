package com.crimeinvestigation.system.model;


public class User extends Person{
    public enum UserType {
        Victim,
        Eyewtiness
    }
    protected String Address;
    protected String email;
protected UserType UserType;


    User(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String Address,
         String email,UserType UserType){
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
        this.Address=Address;
        this.email=email;
this.UserType=UserType;

    }
}

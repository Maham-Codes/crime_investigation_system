package com.crimeinvestigation.system.model;

public class User extends Person{
    protected String Address;
    protected String email;


    User(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender){
        super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
        this.Address=Address;
        this.email=email;


    }
}

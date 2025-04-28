package com.crimeinvestigation.system.model;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Period;


class Person {

    protected String name;
    protected String FatherName;
    protected String contactNumber;
    protected String DOB;
    protected String Occupation;
    protected String CNIC;
    protected int PersonID;
    protected String Gender;

    Person(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender)
    {
        this.name=name;
        this.FatherName=FatherName;
        this.contactNumber=contactNumber;
        this.DOB=DOB;
        this.Occupation=Occupation;
        this.CNIC=CNIC;
        this.PersonID=PersonID;
        this.Gender=Gender;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getOccupation() {
        return Occupation;
    }

    public void setOccupation(String occupation) {
        Occupation = occupation;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int personID) {
        PersonID = personID;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public int getAge() {
        try {
            LocalDate dob = LocalDate.parse(DOB);
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        } catch (Exception e) {
            System.out.println("Invalid date format in DOB. Expected format: yyyy-MM-dd");
            return 0;
        }
    }
}
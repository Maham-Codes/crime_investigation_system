package com.crimeinvestigation.system.model;
import java.util.*;

public class Criminal extends Person {

     protected String CrimeType;
     protected String CurrentStatus;
     protected String Reputation;
     protected String Nationality;

     Criminal(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String
              CrimeType,String CurrentStatus,String Reputation,String Nationality) {
          super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
          this.CrimeType=CrimeType;
          this.CurrentStatus=CurrentStatus;
          this.Reputation=Reputation;
          this.Nationality=Nationality;

     }
     public String getCrimeType() { return CrimeType; }
     public void setCrimeType(String crimeType) { this.CrimeType = crimeType; }
     public String getCurrentStatus() { return CurrentStatus; }
     public void setCurrentStatus(String currentStatus) { this.CurrentStatus = currentStatus; }
     public String getReputation() { return Reputation; }
     public void setReputation(String reputation) { this.Reputation = reputation; }
     public String getNationality() { return Nationality; }
     public void setNationality(String nationality) { this.Nationality = nationality; }

     public void updateStatus(String newStatus) {
          this.CurrentStatus = newStatus;
     }

     public String getDetails() {
          return  "Name: " + getName() + "\n" +
                  "Father's Name: " + getFatherName() + "\n" +
                  "CNIC: " + getCNIC() + "\n" +
                  "Gender: " + getGender() + "\n" +
                  "Date of Birth: " + getDOB() + "\n" +
                  "Occupation: " + getOccupation() + "\n" +
                  "Contact Number: " + getContactNumber() + "\n" +
                  "Person ID: " + getPersonID() + "\n" +
                  "Crime Type: " + CrimeType + "\n" +
                  "Current Status: " + CurrentStatus + "\n" +
                  "Reputation: " + Reputation + "\n" +
                  "Nationality: " + Nationality;
     }


}

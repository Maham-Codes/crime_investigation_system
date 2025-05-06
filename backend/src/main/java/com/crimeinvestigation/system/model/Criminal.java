package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

@Entity
public class Criminal extends Person {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int criminalID;

     protected String crimeType;
     protected String currentStatus;
     protected String reputation;
     protected String nationality;

     // Default constructor
     public Criminal() {}

     // Constructor with parameters
     public Criminal(String name, String FatherName, String contactNumber, String DOB, String Occupation, String CNIC,
                     int PersonID, String Gender, String crimeType, String currentStatus, String reputation, String nationality) {
          super(name, FatherName, contactNumber, DOB, Occupation, CNIC, PersonID, Gender);
          this.crimeType = crimeType;
          this.currentStatus = currentStatus;
          this.reputation = reputation;
          this.nationality = nationality;
     }

     // Getters and setters for criminal-specific fields
//     public int getCriminalID() {
//          return criminalID;
//     }

//     public void setCriminalID(int criminalID) {
//          this.criminalID = criminalID;
//     }

     public String getCrimeType() {
          return crimeType;
     }

     public void setCrimeType(String crimeType) {
          this.crimeType = crimeType;
     }

     public String getCurrentStatus() {
          return currentStatus;
     }

     public void setCurrentStatus(String currentStatus) {this.currentStatus = currentStatus;
     }

     public String getReputation() {
          return reputation;
     }

     public void setReputation(String reputation) {
          this.reputation = reputation;
     }

     public String getNationality() {
          return nationality;
     }

     public void setNationality(String nationality) {
          this.nationality = nationality;
     }
}


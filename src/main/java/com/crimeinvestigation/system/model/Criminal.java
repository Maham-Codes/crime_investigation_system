package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

@Entity

public class Criminal extends Person {

     protected String CrimeType;
     protected String CurrentStatus;
     protected String Reputation;
     protected String Nationality;

     // Default constructor
     public Criminal() {}

     // Constructor with parameters
     public Criminal(String name, String FatherName, String contactNumber, String DOB, String Occupation, String CNIC,
                     int PersonID, String Gender, String CrimeType, String CurrentStatus, String Reputation, String Nationality) {
          super(name, FatherName, contactNumber, DOB, Occupation, CNIC, PersonID, Gender);
          this.CrimeType = CrimeType;
          this.CurrentStatus = CurrentStatus;
          this.Reputation = Reputation;
          this.Nationality = Nationality;
     }


     public String getCrimeType() {
          return CrimeType;
     }

     public void setCrimeType(String crimeType) {
          CrimeType = crimeType;
     }

     public String getCurrentStatus() {
          return CurrentStatus;
     }

     public void setCurrentStatus(String currentStatus) {
          CurrentStatus = currentStatus;
     }

     public String getReputation() {
          return Reputation;
     }

     public void setReputation(String reputation) {
          Reputation = reputation;
     }

     public String getNationality() {
          return Nationality;
     }

     public void setNationality(String nationality) {
          Nationality = nationality;
     }
}


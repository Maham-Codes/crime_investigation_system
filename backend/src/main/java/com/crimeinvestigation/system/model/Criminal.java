package com.crimeinvestigation.system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "criminal")
public class Criminal extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int criminalID;

     @ManyToOne
     @JoinColumn(name = "typeID")
     protected CrimeType crimeType;
     protected String currentStatus;
     protected String reputation;
     protected String nationality;

     // Default constructor
     public Criminal() {}

     // Constructor with parameters
     public Criminal(String name, String FatherName, String contactNumber, String DOB, String Occupation, String CNIC,
                     int PersonID, String Gender, CrimeType crimeType, String currentStatus, String reputation, String nationality) {
          super(name, FatherName, contactNumber, DOB, Occupation, CNIC, PersonID, Gender);
          this.crimeType = crimeType;
          this.currentStatus = currentStatus;
          this.reputation = reputation;
          this.nationality = nationality;
     }


     public CrimeType getCrimeType() {
          return crimeType;
     }

     public void setCrimeType(CrimeType crimeType) {
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


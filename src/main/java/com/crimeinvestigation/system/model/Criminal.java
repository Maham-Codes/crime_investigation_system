package com.crimeinvestigation.system.model;
import java.util.*;

public class Criminal extends Person {

     protected String CrimeType;
     protected String CurrentStatus;
     protected String Reputation;
     protected String Nationality;
     protected List<CrimeCase> crimes;

     Criminal(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String
              CrimeType,String CurrentStatus,String Reputation,String Nationality) {
          super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
          this.CrimeType=CrimeType;
          this.CurrentStatus=CurrentStatus;
          this.Reputation=Reputation;
          this.Nationality=Nationality;
          this.crimes=new ArrayList<>();
     }
     public void setCrimeType(String CrimeType){ this.CrimeType=CrimeType; }
     public String getCrimeType(){ return CrimeType; }
     public void setCurrentStatus(String CurrentStatus){ this.CurrentStatus=CurrentStatus; }
     public String getCurrentStatus(){ return CurrentStatus; }
     public void setReputation(String Reputation){ this.Reputation=Reputation; }
     public String getReputation(){ return Reputation; }
     public void setNationality(String Nationality){ this.Nationality=Nationality; }
     public String getNationality(){ return Nationality; }

     public void addCrime(CrimeCase crime) {
          crimes.add(crime);
     }

     public List<CrimeCase> getCriminalHistory() {
          return crimes;
     }

}

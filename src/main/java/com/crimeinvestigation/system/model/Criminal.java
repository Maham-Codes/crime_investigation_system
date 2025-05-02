package com.crimeinvestigation.system.model;
import jakarta.persistence.*;

import java.util.*;

@Entity
public class Criminal extends Person {

     protected String CrimeType;
     protected String CurrentStatus;
     protected String Reputation;
     protected String Nationality;

     public Criminal(){}
     Criminal(String name,String FatherName,String contactNumber,String DOB, String Occupation,String CNIC,int PersonID,String Gender,String
              CrimeType,String CurrentStatus,String Reputation,String Nationality) {
          super(name,FatherName,contactNumber,DOB,Occupation,CNIC,PersonID,Gender);
          this.CrimeType=CrimeType;
          this.CurrentStatus=CurrentStatus;
          this.Reputation=Reputation;
          this.Nationality=Nationality;

     }


}

package com.crimeinvestigation.system.model;

public class Evidence {
    int evidenceID;
    int caseID ;
   int userID ;
    String evidenceType;

    Evidence(int evidenceID, int caseID, int userID, String evidenceType) {
        this.evidenceID = evidenceID;
        this.caseID = caseID;
        this.userID = userID;
        this.evidenceType = evidenceType;
    }

    public int getEvidenceID(){return evidenceID;}
    public int getCaseID(){return caseID;}
    public int getUserID(){return userID;}
    public String getEvidenceType(){return evidenceType;}
    public void setEvidenceID(int evidenceID){this.evidenceID = evidenceID;}
    public void setCaseID(int caseID){this.caseID = caseID;}
    public void setUserID(int userID){this.userID = userID;}
    public void setEvidenceType(String evidenceType){this.evidenceType = evidenceType;}

    public void displayDetails(){
        System.out.println("Evidence ID: " + evidenceID);
        System.out.println("Case ID: " + caseID);
        System.out.println("User ID: " + userID);
        System.out.println("Evidence Type: " + evidenceType);
    }
}

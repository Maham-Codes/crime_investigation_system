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
}

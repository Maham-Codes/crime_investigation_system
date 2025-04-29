package com.crimeinvestigation.system.model;

import java.time.LocalDate;

public class TrackingStatus {
    private int trackingID;
    private int caseID;
    private String updateSatus;
    private LocalDate updateDate;

    TrackingStatus(int trackingID,int caseID,String updateSatus,LocalDate updateDate){
        this.trackingID=trackingID;
        this.caseID=caseID;
        this.updateSatus=updateSatus;
        this.updateDate=updateDate;
    }
    //getters and setters
    public int getTrackingID() {
        return trackingID;
    }
    public void setTrackingID(int trackingID) {
        this.trackingID = trackingID;
    }
    public int getCaseID() {
        return caseID;
    }
    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
    public String getUpdateSatus() {
        return updateSatus;
    }
    public void setUpdateSatus(String updateSatus) {
        this.updateSatus = updateSatus;
    }
    public LocalDate getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }
    public void displayStatus() {
        System.out.println("Tracking ID: " + trackingID);
        System.out.println("Case ID: " + caseID);
        System.out.println("Status: " + updateSatus);
        System.out.println("Last Updated: " + updateDate);
    }
    public void updateStatus(String newStatus, String comments) {
        this.updateSatus = newStatus;
        this.updateDate = LocalDate.now(); // Automatically update the date when status is changed
    }

}

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

}

package com.crimeinvestigation.system.dto;

// You might need to import other types if your actual DTO is more complex
// import java.time.LocalDateTime;

public class ReportCrimeRequestDto {
    // Fields should match what your frontend sends in the requestBody for reporting a crime
    private String location;
    private String description;
    private Long crimeTypeId; // Assuming frontend sends the ID of the CrimeType
    private String reportedByUserEmail; // To link to the User who reported
    private Boolean cctvPresence;
    // private String dateTime; // If frontend sends this, otherwise backend can set it

    // Default constructor
    public ReportCrimeRequestDto() {
    }

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCrimeTypeId() {
        return crimeTypeId;
    }

    public void setCrimeTypeId(Long crimeTypeId) {
        this.crimeTypeId = crimeTypeId;
    }

    public String getReportedByUserEmail() {
        return reportedByUserEmail;
    }

    public void setReportedByUserEmail(String reportedByUserEmail) {
        this.reportedByUserEmail = reportedByUserEmail;
    }

    public Boolean getCctvPresence() {
        return cctvPresence;
    }

    public void setCctvPresence(Boolean cctvPresence) {
        this.cctvPresence = cctvPresence;
    }

    // public String getDateTime() { return dateTime; }
    // public void setDateTime(String dateTime) { this.dateTime = dateTime; }


    @Override
    public String toString() {
        return "ReportCrimeRequestDto{" +
                "location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", crimeTypeId=" + crimeTypeId +
                ", reportedByUserEmail='" + reportedByUserEmail + '\'' +
                ", cctvPresence=" + cctvPresence +
                // ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
package com.crimeinvestigation.system.model;

import java.time.LocalDate;

public class Feedback {
    private int feedbackID;
    private int userID;
    private int caseID;
    private int rating;
    private String comments;
    private LocalDate feedbackDate;

    public Feedback(int feedbackID, int userID, int caseID, int rating, String comments, LocalDate feedbackDate) {
        this.feedbackID = feedbackID;
        this.userID = userID;
        this.caseID = caseID;
        this.rating = rating;
        this.comments = comments;
        this.feedbackDate = feedbackDate;
    }
    //getters and setters
    public int getFeedbackID() {
        return feedbackID;
    }
    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public int getCaseID() {
        return caseID;
    }
    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }
    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }
    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }
    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("User ID: " + userID);
        System.out.println("Case ID: " + (caseID == 0 ? "Overall Service" : caseID));
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("Feedback Date: " + feedbackDate);
    }
    public void updateFeedback(int newRating, String newComments) {
        this.rating = newRating;
        this.comments = newComments;
    }

}

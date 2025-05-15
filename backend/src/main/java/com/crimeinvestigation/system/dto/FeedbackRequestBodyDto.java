package com.crimeinvestigation.system.dto;

public class FeedbackRequestBodyDto {
    private Integer rating;
    private String comments;
    private String userEmail; // To receive the email from the frontend

    // Default constructor
    public FeedbackRequestBodyDto() {
    }

    // Getters and Setters
    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "FeedbackRequestBodyDto{" +
                "rating=" + rating +
                ", comments='" + comments + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
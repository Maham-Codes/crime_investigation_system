package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*; // Assuming you are using Lombok

import java.time.LocalDate;

@Entity
@Getter
@Setter // Make sure you have setters for all fields being set in the controller
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedbackID;

    @ManyToOne(fetch = FetchType.LAZY) // Default fetch type for @ManyToOne is EAGER
    @JoinColumn(name = "user_id"/*, nullable = false*/) // If user_id MUST NOT be null in DB, add nullable = false
    private User user; // This is the user who submitted the feedback

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "case_id", nullable = false) // Assuming a feedback MUST be linked to a case
    private CrimeCase crimeCase;

    @Column(name = "rating"/*, nullable = false*/) // If rating MUST NOT be null in DB
    private Integer rating; // Use Integer to allow null if the input can be null or not provided

    @Column(name = "comments", columnDefinition = "TEXT") // TEXT for longer comments
    private String comments;

    @Column(name = "feedback_date", nullable = false) // Assuming feedback_date MUST NOT be null
    private LocalDate feedbackDate;

    // Constructor used by FeedbackService (if still needed, otherwise can be removed if not used)
    public Feedback(int rating, String comment) {
        this.rating = rating;
        this.comments = comment;
        this.feedbackDate = LocalDate.now(); // Default date
    }

    // Constructor used by FeedbackService (if still needed)
    public Feedback(int rating, String comments, User user, CrimeCase crimeCase) {
        this.rating = rating;
        this.comments = comments;
        this.user = user;
        this.crimeCase = crimeCase;
        this.feedbackDate = LocalDate.now(); // Default date
    }

    // updateFeedback method might not be needed here if updates are handled via setters
    public void updateFeedback(int newRating, String newComments) {
        this.rating = newRating;
        this.comments = newComments;
        // feedbackDate would typically not be updated
    }

    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("Feedback Date: " + feedbackDate);
        if (user != null) {
            System.out.println("User: " + user.getUsername()); // Or user.getEmail()
        }
        if (crimeCase != null) {
            System.out.println("Case ID: " + crimeCase.getCaseID());
        }
    }
}
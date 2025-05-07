package com.crimeinvestigation.system.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedbackID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "caseID")
    private CrimeCase caseID;

    private int rating;
    private String comments;
    private LocalDate feedbackDate;

    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("User ID: " + userID);
        //System.out.println("Case ID: " + (caseID == 0 ? "Overall Service" : caseID));
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("Feedback Date: " + feedbackDate);
    }
    public void updateFeedback(int newRating, String newComments) {
        this.rating = newRating;
        this.comments = newComments;
    }

}

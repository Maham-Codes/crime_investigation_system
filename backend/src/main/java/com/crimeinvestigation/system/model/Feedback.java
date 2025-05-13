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
    @Column(name = "feedback_id")
    private Long feedbackID;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "case_id")
    private CrimeCase crimeCase;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comments")
    private String comments;

    @Column(name = "feedback_date")
    private LocalDate feedbackDate;

    public Feedback(int rating, String comment) {
        this.rating = rating;
        this.comments = comments;
    }

    public Feedback(int rating, String comments, User user, CrimeCase crimeCase) {
        this.rating = rating;
        this.comments = comments;
        this.user = user;
        this.crimeCase = crimeCase;
    }

    public void updateFeedback(int newRating, String newComments) {
        this.rating = newRating;
        this.comments = newComments;
    }

    public void displayFeedback() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("Rating: " + rating);
        System.out.println("Comments: " + comments);
        System.out.println("Feedback Date: " + feedbackDate);
    }


}

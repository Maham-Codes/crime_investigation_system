
package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.model.Feedback;
import com.crimeinvestigation.system.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedbackById(int id) {
        return feedbackRepository.findById(id).orElse(null); // Simplified to return null if not found
    }

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(int id, Feedback newFeedback) {
        Feedback existingFeedback = getFeedbackById(id);
        if (existingFeedback != null) {
            newFeedback.setFeedbackID(id); // Ensure same ID
            return feedbackRepository.save(newFeedback);
        }
        return null;
    }

    public boolean deleteFeedback(int id) {
        Feedback existingFeedback = getFeedbackById(id);
        if (existingFeedback != null) {
            feedbackRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


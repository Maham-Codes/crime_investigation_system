
package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.Feedback;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.repository.CrimeCaseRepository;
import com.crimeinvestigation.system.repository.FeedbackRepository;
import com.crimeinvestigation.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository; 

    @Autowired
    private CrimeCaseRepository crimeCaseRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Feedback> getAll() {
        return feedbackRepository.findAll();
    }

    public Feedback getById(int id) {
        return feedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Feedback not found with id: " + id));
    }

    public Feedback save(Feedback obj) {
        return feedbackRepository.save(obj);
    }

    public boolean delete(int id) {
        if (!feedbackRepository.existsById(id)) {
            return false;
        }
        feedbackRepository.deleteById(id);
        return true;
    }

    public Feedback add(Feedback feedback) {
        // You can add any validation or preprocessing logic here if needed
        return feedbackRepository.save(feedback);
    }

    public CrimeCase getCaseById(Long caseId) {
        return crimeCaseRepository.findById(caseId).orElse(null);
    }

    public Feedback update(int id, Feedback updatedObj) {
        Feedback existing = getById(id);

        // Update fields
        existing.setRating(updatedObj.getRating());
        existing.setComments(updatedObj.getComments());
        existing.setFeedbackDate(updatedObj.getFeedbackDate());

        // Optional: update user or case only if you allow editing them
        if (updatedObj.getUser() != null) {
            existing.setUser(updatedObj.getUser());
        }
        if (updatedObj.getCrimeCase() != null) {
            existing.setCrimeCase(updatedObj.getCrimeCase());
        }

        return feedbackRepository.save(existing);
    }

    public Double getAverageRatingForCase(Long caseId) {
        return feedbackRepository.findAverageRatingForCase(caseId);
    }
    public void submitFeedback(int rating, String comment) {
        Feedback fb = new Feedback(rating, comment);
        feedbackRepository.save(fb);
    }

    // Overloaded method 2
    public void submitFeedback(int rating, String comment, Long userId, Long caseId) {
        // fetch user and case from DB (assume they exist)
        User user = userRepository.findById(Math.toIntExact(userId)).orElse(null);
        CrimeCase crimeCase = crimeCaseRepository.findById(caseId).orElse(null);
        Feedback fb = new Feedback(rating, comment, user, crimeCase);
        feedbackRepository.save(fb);
    }
}


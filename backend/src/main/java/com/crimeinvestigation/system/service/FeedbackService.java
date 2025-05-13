
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

    public Feedback update(int id, Feedback updatedObj) {
        Feedback existing = getById(id);
        // TODO: update fields here
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



package com.crimeinvestigation.system.service;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.Feedback;
import com.crimeinvestigation.system.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

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

    public void delete(int id) {
        if (!feedbackRepository.existsById(id)) {
            throw new ResourceNotFoundException("Feedback not found with id: " + id);
        }
        feedbackRepository.deleteById(id);
    }

    public Feedback update(int id, Feedback updatedObj) {
        Feedback existing = getById(id);
        // TODO: update fields here
        return feedbackRepository.save(existing);
    }
}


package com.crimeinvestigation.system.controller;
import com.crimeinvestigation.system.model.Feedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.crimeinvestigation.system.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;




@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAll();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable int id) {
        return feedbackService.getById(id);
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.add(feedback);
    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        return feedbackService.update(id, feedback);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable int id) {
        boolean deleted = feedbackService.delete(id);
        return deleted ? "Feedback deleted successfully." : "Feedback not found.";
    }

    @GetMapping("/average/{caseId}")
    public ResponseEntity<Double> getAverage(@PathVariable Long caseId) {
        Double avg = feedbackService.getAverageRatingForCase(caseId);
        return ResponseEntity.ok(avg);
    }
}

package com.crimeinvestigation.system.controller;
import com.crimeinvestigation.system.model.Feedback;
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
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public Feedback getFeedbackById(@PathVariable int id) {
        return feedbackService.getFeedbackById(id);
    }

    @PostMapping
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.addFeedback(feedback);
    }

    @PutMapping("/{id}")
    public Feedback updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        return feedbackService.updateFeedback(id, feedback);
    }

    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable int id) {
        boolean deleted = feedbackService.deleteFeedback(id);
        return deleted ? "Feedback deleted successfully." : "Feedback not found.";
    }
}

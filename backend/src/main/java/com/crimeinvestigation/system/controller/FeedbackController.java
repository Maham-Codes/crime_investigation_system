package com.crimeinvestigation.system.controller;

import com.crimeinvestigation.system.exception.ResourceNotFoundException;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.Feedback;
import com.crimeinvestigation.system.model.User;
import com.crimeinvestigation.system.dto.FeedbackRequestBodyDto; // Ensure this DTO exists
import com.crimeinvestigation.system.service.FeedbackService;
import com.crimeinvestigation.system.repository.UserRepository; // For fetching the user
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final UserRepository userRepository; // To find the User by email

    @Autowired
    public FeedbackController(FeedbackService feedbackService, UserRepository userRepository) {
        this.feedbackService = feedbackService;
        this.userRepository = userRepository;
    }

    @PostMapping("/{caseId}")
    public ResponseEntity<?> addFeedbackToCase(
            @PathVariable Long caseId,
            @RequestBody FeedbackRequestBodyDto feedbackDetails) {

        System.out.println("Received POST request to /api/feedback/" + caseId + " with body: " + feedbackDetails);

        try {
            // Step 1: Validate incoming DTO
            if (feedbackDetails.getUserEmail() == null || feedbackDetails.getUserEmail().trim().isEmpty() || feedbackDetails.getUserEmail().equalsIgnoreCase("undefined")) {
                System.err.println("User email is missing or invalid in the request body.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("User email is required and must be valid to submit feedback.");
            }
            if (feedbackDetails.getRating() == null) {
                System.err.println("Rating is missing in the request body.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Rating is required to submit feedback.");
            }


            // Step 2: Fetch Crime Case by ID
            CrimeCase crimeCase = feedbackService.getCaseById(caseId); // This will throw ResourceNotFound if case doesn't exist
            // No need for null check if getCaseById throws, but if it returns null:
            // if (crimeCase == null) {
            //     return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Case not found with ID: " + caseId);
            // }

            // Step 3: Fetch User by Email provided in the DTO
            Optional<User> userOptional = userRepository.findByEmail(feedbackDetails.getUserEmail());
            if (!userOptional.isPresent()) {
                System.err.println("User with email " + feedbackDetails.getUserEmail() + " not found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("User with email " + feedbackDetails.getUserEmail() + " not found. Ensure you are logged in with a registered email.");
            }
            User feedbackSubmitter = userOptional.get();

            // Step 4: Create Feedback entity
            Feedback feedback = new Feedback();
            feedback.setRating(feedbackDetails.getRating());
            feedback.setComments(feedbackDetails.getComments());
            feedback.setFeedbackDate(LocalDate.now()); // Use current date
            feedback.setCrimeCase(crimeCase);
            feedback.setUser(feedbackSubmitter);

            // Step 5: Save the Feedback entity
            Feedback savedFeedback = feedbackService.add(feedback);

            // Step 6: Return success response
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFeedback);

        } catch (ResourceNotFoundException e) { // Catch specific exception from getCaseById if it throws
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e) {
            System.err.println("An unexpected error occurred while saving feedback for case ID " + caseId + ":");
            e.printStackTrace(); // This will print the full stack trace to your backend console
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An internal server error occurred while processing your feedback. Please try again later.");
        }
    }

    // --- Other methods from your controller ---
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAll();
        return ResponseEntity.ok(feedbackList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable int id) {
        Feedback feedback = feedbackService.getById(id); // Throws ResourceNotFound if not found
        return ResponseEntity.ok(feedback);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        Feedback updated = feedbackService.update(id, feedback); // Throws ResourceNotFound if not found
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable int id) {
        boolean deleted = feedbackService.delete(id); // Service handles not found by returning false
        if (deleted) {
            return ResponseEntity.ok("Feedback with ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Feedback not found with ID: " + id);
        }
    }

    @GetMapping("/average/{caseId}")
    public ResponseEntity<Double> getAverage(@PathVariable Long caseId) {
        Double avg = feedbackService.getAverageRatingForCase(caseId);
        if (avg == null) { // Handle cases where no ratings exist or case not found
            return ResponseEntity.ok(0.0); // Or return 404 if appropriate
        }
        return ResponseEntity.ok(avg);
    }
}
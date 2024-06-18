package com.example.restapp.controller;

import com.example.restapp.model.Feedback;
import com.example.restapp.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class FeedbackController {

        @Autowired
        private FeedbackRepository feedbackRepository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{bottleId}")
    public ResponseEntity<List<Feedback>> getFeedbacksForBottle(@PathVariable Long bottleId) {
        try {
            List<Feedback> feedbacks = feedbackRepository.findByBottleId(bottleId);
            return ResponseEntity.ok(feedbacks);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // POST method to add feedback
    @PostMapping("/add")
    public ResponseEntity<String> addFeedback(@RequestBody Feedback feedback) {
        try {
            // You can add any validation logic here before saving to the database
            feedbackRepository.save(feedback);
            return ResponseEntity.status(HttpStatus.CREATED).body("Feedback added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add feedback");
        }
    }






}

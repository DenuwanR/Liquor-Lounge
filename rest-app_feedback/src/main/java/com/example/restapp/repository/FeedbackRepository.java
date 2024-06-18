package com.example.restapp.repository;

import com.example.restapp.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByBottleId(Long bottleId);
}

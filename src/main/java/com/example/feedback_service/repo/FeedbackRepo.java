package com.example.feedback_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.feedback_service.model.Feedback;


@Repository
public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}

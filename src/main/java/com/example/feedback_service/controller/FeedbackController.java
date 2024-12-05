package com.example.feedback_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.feedback_service.model.Feedback;
import com.example.feedback_service.model.FeedbackDto;
import com.example.feedback_service.service.FeedbackService;
import com.example.feedback_service.model.*;


@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	@Autowired
	FeedbackService feedbackService;
	@PostMapping("/create")
	public ResponseEntity<String> createFeedback(@RequestBody FeedbackDto feedbackdto){
		return feedbackService.createFeedback(feedbackdto.getPosition(),feedbackdto.getTitle(),feedbackdto.getNum());
	}
	@GetMapping("/get/{id}")
	public List<EmployeeEntity> getFeedback(@PathVariable int id){
		return feedbackService.getFeedback(id);
	}
}

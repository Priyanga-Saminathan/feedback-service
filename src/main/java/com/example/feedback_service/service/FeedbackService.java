package com.example.feedback_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.feedback_service.feign.FeedbackFeign;
import com.example.feedback_service.model.EmployeeEntity;
import com.example.feedback_service.model.Feedback;
import com.example.feedback_service.repo.FeedbackRepo;



@Service
public class FeedbackService {
	@Autowired
	FeedbackRepo feedbackrepo;
	@Autowired
	FeedbackFeign feedbackfeign;
//	@Autowired
//	EmployeeRepo emprepo;
	public ResponseEntity<String> createFeedback(String position,String title, int num) {
		List<Integer> empId=feedbackfeign.createFeedback(position, num).getBody();
		Feedback feed=new Feedback();
		feed.setTitle(title);
		feed.setFeedback(empId);
		feedbackrepo.save(feed);
		
		return new ResponseEntity<>("success",HttpStatus.CREATED);
		
	}
	public List<EmployeeEntity> getFeedback(int id) {
		Feedback empIDs=feedbackrepo.findById(id).get();
		List<EmployeeEntity> empfeed=feedbackfeign.getEmpFeedback(empIDs.getFeedback()).getBody();
		return empfeed;
	}
}

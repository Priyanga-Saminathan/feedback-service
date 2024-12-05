package com.example.feedback_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.feedback_service.model.EmployeeEntity;



@FeignClient("EMPLOYEE-SERVICE")
public interface FeedbackFeign {
	@GetMapping("employee/createFeedback")
	public ResponseEntity<List<Integer>> createFeedback(@RequestParam String position,@RequestParam int num);
	@PostMapping("employee/getEmpFeedback")
	public ResponseEntity<List<EmployeeEntity>> getEmpFeedback(@RequestBody List<Integer> empid)
;
}

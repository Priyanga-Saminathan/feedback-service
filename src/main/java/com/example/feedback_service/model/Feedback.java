package com.example.feedback_service.model;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="feed")
public class Feedback {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idf;
	private String title;
	@ElementCollection
	private List<Integer> feedback;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setFeedback(List<Integer> feedback) {
		this.feedback=feedback;
	}
	public List<Integer> getFeedback(){
		return this.feedback;
	}
	

	
}

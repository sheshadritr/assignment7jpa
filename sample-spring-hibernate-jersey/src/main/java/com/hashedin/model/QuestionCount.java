package com.hashedin.model;


public class QuestionCount {
	
	private Long noOfQuestions;
	private String createdDate;

	public Long getQuestionCount() {
		return noOfQuestions;
	}

	public void setQuestionCount(Long questionCount) {
		this.noOfQuestions = questionCount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public QuestionCount(int createdDate, Long questionCount) {
		super();
		this.createdDate = String.valueOf(createdDate);
		this.noOfQuestions = questionCount;
	}

	public QuestionCount() {
		super();
		// Auto-generated constructor stub
	}
	
}

package com.hashedin.model;

import java.util.Date;


public class QuestionCount {
	
	private Long noOfQuestions;
	private Date createdDate;

	public Long getQuestionCount() {
		return noOfQuestions;
	}

	public void setQuestionCount(Long questionCount) {
		this.noOfQuestions = questionCount;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public QuestionCount(Date createdDate, Long questionCount) {
		super();
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		//this.createdDate = (Date) formatter.parse(formatter.format(createdDate));
		this.createdDate = createdDate;
		this.noOfQuestions = questionCount;
	}

	public QuestionCount() {
		super();
		// Auto-generated constructor stub
	}
	
}

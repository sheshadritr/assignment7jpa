package com.hashedin.model;

public class QuestionAnswers {
	
	private Long totalAnswers;
	private Long totalQuestions;
	
	public Long getTotalAnswers() {
		return totalAnswers;
	}
	
	public void setTotalAnswers(Long totalAnswers) {
		this.totalAnswers = totalAnswers;
	}
	
	public Long getTotalQuestions() {
		return totalQuestions;
	}
	
	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}
	
	public QuestionAnswers(Long totalQuestions, Long totalAnswers) {
		super();
		this.totalAnswers = totalAnswers;
		this.totalQuestions = totalQuestions;
	}
	public QuestionAnswers() {
		super();
		// Auto-generated constructor stub
	}
	
}

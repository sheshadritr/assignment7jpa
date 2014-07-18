package com.hashedin.model;

public class QuestionView {
	
	private Long totalViews;
	private Long totalQuestions;

	public Long getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(Long totalViews) {
		this.totalViews = totalViews;
	}

	public Long getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Long totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public QuestionView(Long totalQuestions, Long totalViews) {
		super();
		this.totalQuestions = totalQuestions;
		this.totalViews = totalViews;
	}

	public QuestionView() {
		super();
		// Auto-generated constructor stub
	}
	
}

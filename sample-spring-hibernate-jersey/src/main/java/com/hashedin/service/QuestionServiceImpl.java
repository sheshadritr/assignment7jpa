package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.model.Question;
import com.hashedin.model.QuestionAnswers;
import com.hashedin.model.QuestionCount;
import com.hashedin.model.QuestionView;
import com.hashedin.model.Tag;
import com.hashedin.repository.QuestionRepository;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question find(Long questionId) {
	
		return questionRepository.find(questionId);
	}

	@Override
	public List<Question> findAll() {
		
		return questionRepository.findAll();
	}

	@Override
	public List<Tag> findTagsForQuestion(Long questionId) {
		
	    return questionRepository.findTagsForQuestion(questionId);
	}

	@Override
	public List<QuestionCount> findNoOfQuestions() {
		
		return questionRepository.findNoOfQuestions();
	}

	@Override
	public QuestionView findSumOfViews() {
		
		return questionRepository.findSumOfViews();
	}

	@Override
	public QuestionAnswers findSumOfAnswers() {
		
		return questionRepository.findSumOfAnswers();
	}
}

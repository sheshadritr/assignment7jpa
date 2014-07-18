package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Question;
import com.hashedin.model.QuestionAnswers;
import com.hashedin.model.QuestionCount;
import com.hashedin.model.QuestionView;
import com.hashedin.model.Tag;

@Repository("questionRepository")
public class QuestionRepositoryImpl implements QuestionRepository  {

	
	 @PersistenceContext
	 private EntityManager em;
	 
	@Override
	public Question find(Long questionId) {
		// TODO Auto-generated method stub
		return em.find(Question.class, questionId);
	}

	@Override
	public List<Question> findAll() {
		
		TypedQuery<Question> query = em.createNamedQuery("Question.findAll", Question.class);
        List<Question> results = query.getResultList();
        return results;
	}

	@Override
	public List<Tag> findTagsForQuestion(Long questionId) {
		//returns tags for a particular question
		return em.find(Question.class, questionId).getTaglist();
	}
	
	@Override
	public List<QuestionCount> findNoOfQuestions() {
		//Returns number of questions we have in our system.
		TypedQuery<QuestionCount> query = em.createNamedQuery("Question.getDateWiseCount", QuestionCount.class);
		List<QuestionCount> results = query.getResultList();
        return results;
	}
	
	@Override
	public QuestionView findSumOfViews() {
		//Returns number of questions and sum of views we have in our system.
		TypedQuery<QuestionView> query = em.createNamedQuery("Question.getViewSum", QuestionView.class);
		QuestionView results = query.getSingleResult();
        return results;
	}

	@Override
	public QuestionAnswers findSumOfAnswers() {
		//Returns number of questions and sum of answers we have in our system.
		TypedQuery<QuestionAnswers> query = em.createNamedQuery("Question.getAnswerSum", QuestionAnswers.class);
		QuestionAnswers results = query.getSingleResult();
        return results;
	}

}

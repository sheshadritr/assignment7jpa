package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Question;
import com.hashedin.model.QuestionAnswers;
import com.hashedin.model.QuestionCount;
import com.hashedin.model.QuestionView;
import com.hashedin.model.Tag;

public interface QuestionRepository {
	
	
	Question find(Long questionId);
    List<Question> findAll();
    List<Tag> findTagsForQuestion( Long questionId);
    List<QuestionCount> findNoOfQuestions();
    QuestionView findSumOfViews();
	QuestionAnswers findSumOfAnswers();
}

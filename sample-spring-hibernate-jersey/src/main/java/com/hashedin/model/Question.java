package com.hashedin.model;

import java.util.Date;
//import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;

@XmlRootElement
@Entity
@Table(name = "question")
@NamedQueries({ @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
	@NamedQuery(name = "Question.getDateWiseCount", query = "SELECT NEW com.hashedin.model.QuestionCount(q.year, count(q)) FROM Question q GROUP BY q.year"),
	@NamedQuery(name = "Question.getViewSum", query = "SELECT NEW com.hashedin.model.QuestionView(count(q), sum(q.viewCount)) FROM Question q"),
	@NamedQuery(name = "Question.getAnswerSum", query = "SELECT NEW com.hashedin.model.QuestionAnswers(count(q), sum(q.answerCount)) FROM Question q")
})

/*
 *
 * */
public class Question {

	@Id
	private Long questionId;
	
	private String questionTitle;
	private String questionLink;
	private Boolean isAnswered;
	private Long viewCount;
	private Long answerCount;
	private Long score;
	private Date lastActivityDate;
	private Date creationDate;
	private int year;
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@XmlInverseReference(mappedBy = "questionid")
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "questionid")
	List<Tag> taglist;

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public String getQuestionLink() {
		return questionLink;
	}

	public void setQuestionLink(String questionLink) {
		this.questionLink = questionLink;
	}

	public Boolean getIsAnswered() {
		return isAnswered;
	}

	public void setIsAnswered(Boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

	public Long getViewCount() {
		return viewCount;
	}

	public void setViewCount(Long viewCount) {
		this.viewCount = viewCount;
	}

	public Long getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(Long answerCount) {
		this.answerCount = answerCount;
	}

	public Long getScore() {
		return score;
	}

	public void setScore(Long score) {
		this.score = score;
	}

	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public List<Tag> getTaglist() {
		return taglist;
	}

	public void setTaglist(List<Tag> taglist) {
		this.taglist = taglist;
	}
	
}

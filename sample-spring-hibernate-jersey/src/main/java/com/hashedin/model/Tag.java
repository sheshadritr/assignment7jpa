package com.hashedin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "tags")
@NamedQueries({ @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t"),
	@NamedQuery(name = "Tag.getAssociateTags", query = "SELECT NEW com.hashedin.model.AssociateTags(t.tagName, count(t)) FROM Tag t GROUP BY t.tagName")
})
/*
 * 
 * 
 * */
public class Tag {
	
	@Id
    private Long tagId;
    
    private String tagName;
    
    @ManyToOne
    private Question questionid;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Question getQuestionid() {
		return questionid;
	}

	public void setQuestionid(Question questionid) {
		this.questionid = questionid;
	}
    
}

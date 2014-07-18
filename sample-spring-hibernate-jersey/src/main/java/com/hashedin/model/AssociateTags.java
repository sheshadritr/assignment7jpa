package com.hashedin.model;

public class AssociateTags {
	
    private Long tagCount;
    
    private String tagAssociated;

	public Long getTagCount() {
		return tagCount;
	}

	public void setTagCount(Long tagCount) {
		this.tagCount = tagCount;
	}

	public String getTagAssociated() {
		return tagAssociated;
	}

	public void setTagAssociated(String tagAssociated) {
		this.tagAssociated = tagAssociated;
	}

	public AssociateTags(String tagAssociated, Long tagCount) {
		super();
		this.tagCount = tagCount;
		this.tagAssociated = tagAssociated;
	}

	public AssociateTags() {
		super();
		// Auto-generated constructor stub
	}
    
}

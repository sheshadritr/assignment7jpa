package com.hashedin.service;

import java.util.List;

import com.hashedin.model.AssociateTags;
import com.hashedin.model.Tag;

public interface TagService {

    Tag find(Long tagId);
    List<Tag> findAll();
	List<AssociateTags> getAssociateTagsCount();
    
}

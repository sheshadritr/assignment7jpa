package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.AssociateTags;
import com.hashedin.model.Tag;

public interface TagRepository {

    Tag find(Long taskId);
    List<Tag> findAll();
	List<AssociateTags> getAssociateTagsCount();
   
 }

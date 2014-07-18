package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hashedin.model.AssociateTags;
import com.hashedin.model.Tag;
import com.hashedin.repository.TagRepository;


@Service("tagService")
public class TagServiceImpl implements TagService
{

    @Autowired
    private TagRepository tagRepository;


    public Tag find(Long tagId)
    {
        // Returns the Tag for given tagId.
        return tagRepository.find(tagId);
    }

    @Override
    public List<Tag> findAll()
    {
        // Returns all the tags in our system.
        return tagRepository.findAll();
    }

	@Override
	public List<AssociateTags> getAssociateTagsCount() {
		// Returns count of tags in each tagName category.
		return tagRepository.getAssociateTagsCount();
	}
    
}

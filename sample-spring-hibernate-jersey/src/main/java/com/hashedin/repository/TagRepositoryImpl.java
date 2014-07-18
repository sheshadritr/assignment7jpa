package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.AssociateTags;
import com.hashedin.model.Tag;

@Repository("tagRepository")
public class TagRepositoryImpl implements TagRepository
{

    @PersistenceContext
    private EntityManager em;
    
    public Tag find(Long tagId) {
        // Returns the Tag for given tagId.
        return em.find(Tag.class, tagId);
    }

    @Override
    public List<Tag> findAll() {
        // Returns all the tags in our system.
        TypedQuery<Tag> query = em.createNamedQuery("Tag.findAll", Tag.class);
        List<Tag> results = query.getResultList();
        return results;
    }

	@Override
	public List<AssociateTags> getAssociateTagsCount() {
		// Returns count of tags in each tagName category.
		TypedQuery<AssociateTags> query = em.createNamedQuery("Tag.getAssociateTags", AssociateTags.class);
        List<AssociateTags> results = query.getResultList();
        return results;
	}

}

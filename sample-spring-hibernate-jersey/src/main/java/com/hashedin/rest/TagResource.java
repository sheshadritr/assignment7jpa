package com.hashedin.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.AssociateTags;
import com.hashedin.model.Tag;
import com.hashedin.service.TagService;


@Component
@Path("/tags")
public class TagResource
{

    @Autowired
    private TagService tagService;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Tag> list()
    {
        // Handles GET on /tags. Lists all the tags we have in our system.
    	return tagService.findAll();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{tagId}")
    public Tag get(@PathParam("tagId") Long tagId)
    {
        // Handles GET on /tags/{tagId}. Returns a single tag for the given tagId.
        return tagService.find(tagId);
    }
    
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/associated")
    public List<AssociateTags> getAssociateTagsCount()
    {
        // Handles GET on /tags/associated. Returns count of tags in each tagName category.
        return tagService.getAssociateTagsCount();
    }
    
}
